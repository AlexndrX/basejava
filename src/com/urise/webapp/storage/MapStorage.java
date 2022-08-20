package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        int size = storage.size();
        return storage.values().toArray(new Resume[size]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected Object findIndex(String uuid) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getKey().equals(uuid)) {
                return entry.getValue();
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getKey().equals(searchKey)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        storage.replace((String) searchKey, resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected Object ExistSearchKey(String uuid) {
        if (!storage.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return findIndex(uuid);
    }

    @Override
    protected Object NotExistSearchKey(String uuid) {
        if (storage.containsKey(uuid)) {
            throw new ExistStorageException(uuid);
        }
        return findIndex(uuid);
    }
}
