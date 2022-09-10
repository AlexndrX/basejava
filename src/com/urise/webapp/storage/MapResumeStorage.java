package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> storage = new LinkedHashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume doGet(Resume r) {
        return r;
    }

    @Override
    protected void doUpdate(Resume resume, Resume r) {
        storage.replace(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume resume, Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume r) {
        storage.remove(r.getUuid());
    }

    @Override
    protected boolean isExist(Resume r) {
        return !isNull(r);
    }
}
