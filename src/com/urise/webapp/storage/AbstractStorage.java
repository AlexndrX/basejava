package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected final Comparator<Resume> resumeComparator =
            Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        list.sort(resumeComparator);
        return list;
    }

    @Override
    public final void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistingSearchKey(r.getUuid());
        doUpdate(searchKey, r);
    }

    @Override
    public final void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistingSearchKey(r.getUuid());
        doSave(searchKey, r);
    }

    @Override
    public final Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public final void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    public SK getExistingSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    public SK getNotExistingSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract SK findSearchKey(String uuid);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume r);

    protected abstract void doSave(SK searchKey, Resume r);

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract List<Resume> doCopyAll();
}
