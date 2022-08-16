package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage implements Storage {
    List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        Iterator<Resume> iterator = resumeList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    @Override
    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        resumeList.add(index, r);
    }

    @Override
    public void save(Resume r) {
        if (resumeList.contains(r)) {
            throw new ExistStorageException(r.getUuid());
        }
        resumeList.add(r);
    }

    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return resumeList.get(index);
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        resumeList.remove(index);
    }

    @Override
    public Resume[] getAll() {
        int size = resumeList.size();
        return resumeList.toArray(new Resume[size]);
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    int findIndex(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (uuid.equals(resumeList.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
