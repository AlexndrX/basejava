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
    protected void addResume(Resume r, int index) {
        int indexOfResume = Math.abs(index + 1);
        System.arraycopy(storage, indexOfResume, storage, indexOfResume + 1, count - indexOfResume);
        storage[indexOfResume] = r;
        count++;
    }

    @Override
    protected void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, count - (index + 1));
        count--;
    }
}
