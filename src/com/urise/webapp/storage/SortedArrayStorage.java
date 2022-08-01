package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    protected void addResume(Resume r, int index) {
        int indexOfResume = Math.abs(index + 1);
        System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, count - indexOfResume);
        storage[indexOfResume] = r;
    }

    @Override
    protected void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, count - (index + 1));
    }
}
