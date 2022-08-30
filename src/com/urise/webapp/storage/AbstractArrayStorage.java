package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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
    public List<Resume> doSortList() {
        Arrays.sort(storage, resumeComparator);
        return Arrays.asList(Arrays.copyOf(storage, count));
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
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
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }
}
