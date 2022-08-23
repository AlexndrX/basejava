package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        addResume(resume, (Integer) searchKey);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        if (count == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        addResume(resume, (Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        deleteResume((Integer) searchKey);
    }

    protected abstract void addResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    @Override
    protected boolean isExist(String uuid) {
        int index = (int) findIndex(uuid);
        return index >= 0;
    }
}
