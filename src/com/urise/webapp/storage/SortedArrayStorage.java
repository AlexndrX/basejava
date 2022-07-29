package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count,searchKey);
    }

    @Override
    protected void addResume(Resume r) {
        if (count == 0){
            storage[count] = r;
            count++;
            return;
        }
        int index = Math.abs(Arrays.binarySearch(storage, 0, count, r) + 1);

        for (int i = count; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = r;
        count++;
    }

    @Override
    protected void shift(int index) {
        for (int i = index; i < count; i++) {
            storage[i] = storage[i + 1];
        }
        storage[count - 1] = null;
        count--;
    }

}
