package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int count = 0;

    public void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    public void save(Resume r) {
        storage[count] = r;
        count++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(storage[i].getUuid(), uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {

                for (int j = i + 1; j < count; j++) {
                    storage[j - 1] = storage[j];
                }
                storage[count -1] = null;
                count--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] fullStorage = new Resume[count];
        for (int i = 0; i < count; i++) {
            fullStorage[i] = storage[i];
        }
        return fullStorage;
    }

    public int size() {
        return count;
    }
}