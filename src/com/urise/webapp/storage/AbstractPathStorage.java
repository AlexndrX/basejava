package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path>{

    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)){
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected Path findSearchKey(String uuid) {
        return null;
    }


    @Override
    protected Resume doGet(Path searchKey) {
        return null;
    }

    @Override
    protected void doUpdate(Path searchKey, Resume r) {

    }

    @Override
    protected void doSave(Path searchKey, Resume r) {

    }

    @Override
    protected void doDelete(Path searchKey) {

    }

    @Override
    protected boolean isExist(Path searchKey) {
        return false;
    }

    protected abstract void doWrite(OutputStream os, Resume r) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

}
