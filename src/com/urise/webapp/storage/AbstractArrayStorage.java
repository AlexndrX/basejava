package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, count));
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume r) {
        addResume(r, searchKey);
    }

    @Override
    protected void doSave(Integer searchKey, Resume r) {
        if (count == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        addResume(r, searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        deleteResume(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected abstract void addResume(Resume r, int searchKey);

    protected abstract void deleteResume(int searchKey);
}
