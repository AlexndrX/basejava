package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage {
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
    public void save(Resume r) {
        if (resumeList.contains(r)) {
            throw new ExistStorageException(r.getUuid());
        }
        resumeList.add(r);
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

    protected int findIndex(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (uuid.equals(resumeList.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void addResume(Resume r, int index) {
        resumeList.add(index, r);
    }

    @Override
    protected Resume getResume(int index) {
        return resumeList.get(index);
    }

    @Override
    protected void deleteResume(int index) {
        resumeList.remove(index);
    }
}
