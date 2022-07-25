package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];

    private int count = 0;

    public void clear() {
        Arrays.fill(storage, null);
        count = 0;
    }

    public int findIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Error: this resume with " + r.getUuid() + " not present");
            return;
        }
        storage[index] = r;
    }

    public void save(Resume r) {
        if (count == STORAGE_LIMIT) {
            System.out.println("Error: storage is complete");
        } else if (findIndex(r.getUuid()) >= 0) {
            System.out.println("Error: this resume with " + r.getUuid() + " is present");
        } else {
            storage[count] = r;
            count++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Error: this resume not present");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Error: this resume with uuid: " + uuid + " not present");
        } else {
            storage[index] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}
