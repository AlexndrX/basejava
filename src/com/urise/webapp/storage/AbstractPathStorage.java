package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {

    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
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
        if (directory == null) {
            throw new StorageException("Directory is null", null);
        }
        try {
            List<String> list = Files.readAllLines(directory);
            List<Resume> resumeList = new ArrayList<>();
            for (String s : list) {
                resumeList.add(doGet(Paths.get(s)));
            }
            return resumeList;
        } catch (IOException e) {
            throw new StorageException("IO error", null);
        }
    }

    @Override
    public int size() {
        if (Files.notExists(directory)) {
            throw new StorageException("Directory is null", null);
        }
        try {
            return (int) Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("IO Error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected Path findSearchKey(String uuid) {
        return Paths.get(uuid);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("IO Error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doUpdate(Path path, Resume r) {
        try {
            doWrite(new BufferedOutputStream(Files.newOutputStream(path)), r);
        } catch (IOException e) {
            throw new StorageException("IO Error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doSave(Path path, Resume r) {
        try {
            Files.createFile(path);
            doWrite(new BufferedOutputStream(Files.newOutputStream(path)), r);
        } catch (IOException e) {
            throw new StorageException("IO Error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null, e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    protected abstract void doWrite(OutputStream os, Resume r) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

}
