package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "  is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "  is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = getArrayFiles(directory);
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = getArrayFiles(directory);
        List<Resume> resumeList = new ArrayList<>();
        for (File file : files) {
            resumeList.add(doGet(file));
        }
        return resumeList;
    }

    @Override
    public int size() {
        File[] files = getArrayFiles(directory);
        return files.length;
    }

    @Override
    protected File findSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File get error", file.getName(), e);
        }
    }

    @Override
    protected void doUpdate(File file, Resume r) {
        try {
            doWrite(new BufferedOutputStream(new FileOutputStream(file)), r);
        } catch (IOException e) {
            throw new StorageException("File update error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(File file, Resume r) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("File create error", file.getName(), e);
        }
        doUpdate(file, r);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    protected abstract void doWrite(OutputStream os, Resume r) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    private File[] getArrayFiles(File directory) throws StorageException {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory is null", directory.getName());
        }
        return files;
    }
}
