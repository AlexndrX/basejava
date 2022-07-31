package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
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
        int index = findIndex(r.getUuid());
        if (count == STORAGE_LIMIT) {
            System.out.println("Error: storage is complete");
        } else if (index >= 0) {
            System.out.println("Error: this resume with " + r.getUuid() + " is present");
        } else {
            addResume(r, index);
            count++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error: this resume not present");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error: this resume with uuid: " + uuid + " not present");
        } else {
            deleteResume(index);
            storage[count - 1] = null;
            count--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    protected abstract int findIndex(String uuid);

    protected abstract void deleteResume(int index);

    protected abstract void addResume(Resume r, int index);

}
