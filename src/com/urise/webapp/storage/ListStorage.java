package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Integer findSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume r) {
        storage.set(searchKey, r);
    }

    @Override
    protected void doSave(Integer searchKey, Resume r) {
        storage.add(r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
