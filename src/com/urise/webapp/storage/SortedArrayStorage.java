package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Integer findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, count, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void addResume(Resume r, int searchKey) {
        int indexOfResume = Math.abs(searchKey + 1);
        System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, count - indexOfResume);
        storage[indexOfResume] = r;
    }

    @Override
    protected void deleteResume(int searchKey) {
        System.arraycopy(storage, searchKey + 1, storage, searchKey, count - (searchKey + 1));
        count--;
    }
}
