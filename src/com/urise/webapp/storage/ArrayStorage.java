package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int findIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void addResume(Resume r) {
        storage[count] = r;
        count++;
    }

    @Override
    protected void shift(int index) {
        storage[index] = storage[count - 1];
        storage[count - 1] = null;
        count--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

}
