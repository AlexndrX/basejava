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

    public void update(Resume r){
        boolean isExist = false;
        for (int i = 0; i < count; i++) {
            if (r == storage[i]){
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Error: this resume with " + r.getUuid() + " not present");
        }
    }

    public void save(Resume r) {
        boolean isNotExist = true;
        for (int i = 0; i < count; i++) {
            if (r.equals(storage[i]) || r.getUuid().equals(storage[i].getUuid())){
                isNotExist = false;
            }
        }

        boolean isComplete = false;
        if (count == 10000){
            isComplete = true;
        }

        if (isNotExist && !isComplete){
            storage[count] = r;
            count++;
        } else {
            System.out.println("Error: this resume with " + r.getUuid() + " is present or storage is complete");
        }
    }

    public Resume get(String uuid) {
        boolean isExist = false;
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())){
                isExist = true;
                break;
            }
        }

        if (isExist){
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
        boolean isExist = false;
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())){
                isExist = true;
                break;
            }
        }

        if (isExist){
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
        } else {
            System.out.println("Error: this resume with uuid: " + uuid + " not present");
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
