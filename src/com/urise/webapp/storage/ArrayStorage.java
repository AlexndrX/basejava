package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int count = 0;

    public void clear() {
        Resume[] tempStorage = Arrays.copyOf(storage, count);
        Arrays.fill(tempStorage, null);
        count = 0;
    }

    public boolean isExistResume(Resume r) {
        for (int i = 0; i < count; i++) {
            if (r.equals(storage[i]) || r.getUuid().equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistID(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    public void update(Resume r) {
        if (!isExistResume(r)) {
            System.out.println("Error: this resume with " + r.getUuid() + " not present");
        }
    }

    public void save(Resume r) {

        boolean isComplete = false;
        if (count == 10000) {
            isComplete = true;
        }

        if (!isExistResume(r) && !isComplete) {
            storage[count] = r;
            count++;
        } else {
            System.out.println("Error: this resume with " + r.getUuid() + " is present or storage is complete");
        }
    }

    public Resume get(String uuid) {
        if (isExistID(uuid)) {
            for (int i = 0; i < count; i++) {
                if (Objects.equals(storage[i].getUuid(), uuid)) {
                    return storage[i];
                }
            }
        }
        System.out.println("Error: this resume not present");
        return null;
    }

    public void delete(String uuid) {
        if (isExistID(uuid)) {
            for (int i = 0; i < count; i++) {
                if (storage[i].uuid == uuid) {

                    for (int j = i + 1; j < count; j++) {
                        storage[j - 1] = storage[j];
                    }
                    storage[count - 1] = null;
                    count--;
                    break;
                }
            }
        } else {
            System.out.println("Error: this resume with uuid: " + uuid + " not present");
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
