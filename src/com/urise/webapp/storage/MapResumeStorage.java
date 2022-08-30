package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private final Map<Resume, String> storage = new LinkedHashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> doSortList() {
        List<Resume> resumes = new ArrayList<>(storage.keySet());
        resumes.sort(resumeComparator);
        return List.copyOf(resumes);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume findIndex(String uuid) {
        for (Map.Entry<Resume, String> entry : storage.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        if (storage.containsKey((Resume) searchKey)) {
            return (Resume) searchKey;
        }
        return null;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        storage.replace((Resume) searchKey, ((Resume) searchKey).getUuid());
    }

    @Override
    protected void doSave(Object searchKey, Resume r) {
        storage.put((Resume) searchKey, ((Resume) searchKey).getUuid());
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((Resume) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey((Resume) searchKey);
    }
}
