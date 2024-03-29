package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer findSearchKey(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void addResume(Resume r, int searchKey) {
        storage[count] = r;
    }

    @Override
    protected void deleteResume(int searchKey) {
        storage[searchKey] = storage[count - 1];
        storage[count - 1] = null;
        count--;
    }
}
