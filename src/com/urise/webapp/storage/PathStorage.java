package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serialisation.Serializator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {

    private final Path directory;

    private final Serializator serializator;

    protected PathStorage(String dir, Serializator serializator) {
        directory = Paths.get(dir);
        this.serializator = serializator;
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    public void clear() {
        try {
            getStreamPath(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null, e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        try {
            List<Path> list = getStreamPath(directory).toList();
            List<Resume> resumeList = new ArrayList<>();
            for (Path path : list) {
                resumeList.add(doGet(path));
            }
            return resumeList;
        } catch (IOException e) {
            throw new StorageException("It isn't a directory", directory.getFileName().toString(), e);
        }
    }

    @Override
    public int size() {
        try {
            return (int) getStreamPath(directory).count();
        } catch (IOException e) {
            throw new StorageException("It isn't a directory", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected Path findSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return serializator.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("File get error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doUpdate(Path path, Resume r) {
        try {
            serializator.doWrite(new BufferedOutputStream(Files.newOutputStream(path)), r);
        } catch (IOException e) {
            throw new StorageException("File update error", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doSave(Path path, Resume r) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("File create error", directory.getFileName().toString(), e);
        }
        doUpdate(path, r);
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

    private Stream<Path> getStreamPath(Path directory) throws IOException {
        if (directory == null) {
            throw new StorageException("Directory is null", null);
        }
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("It isn't a directory", null, e);
        }
    }
}
