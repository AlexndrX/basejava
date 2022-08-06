package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_5 = "uuid5";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        int count = storage.size();
        Assert.assertEquals(0, count);
    }

    @Test
    public void update() {
        storage.update(new Resume("uuid2"));
        Resume r2 = storage.get("uuid2");
        Assert.assertEquals(r2, storage.get(("uuid2")));
    }

    @Test
    public void save() {
        storage.save(new Resume(UUID_4));
        Resume resume = storage.get(UUID_4);
        Assert.assertSame(resume, storage.get(UUID_4));
    }

    @Test
    public void get() {
        Resume resume = storage.get("uuid1");
        Assert.assertEquals(resume, storage.get("uuid1"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid2");
        storage.get("uuid2");
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume("uuid3"));
    }

    @Test(expected = StorageException.class)
    public void saveShouldTrowStorageException() {
        try {
            storage.save(new Resume(UUID_4));
            storage.save(new Resume(UUID_5));
        } catch (StorageException e) {
            Assert.fail("Storage overflowed ahead of time");
        }
        storage.save(new Resume("uuid6"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("uuid7"));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("uuid7");
    }
}