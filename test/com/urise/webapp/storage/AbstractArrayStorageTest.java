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
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";

    final Resume RESUME_1 = new Resume(UUID_1);
    final Resume RESUME_2 = new Resume(UUID_2);
    final Resume RESUME_3 = new Resume(UUID_3);
    final Resume RESUME_4 = new Resume(UUID_4);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        int count = assertSize(0);
        Assert.assertEquals(0, count);
        Resume[] empResume = new Resume[0];
        Assert.assertArrayEquals(empResume, storage.getAll());
    }

    @Test
    public void update() {
        storage.update(RESUME_2);
        Assert.assertSame(RESUME_2, storage.get((RESUME_2.getUuid())));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertSame(assertGet(RESUME_4), storage.get(RESUME_4.getUuid()));
        Assert.assertEquals(assertSize(4), storage.size());
    }

    public Resume assertGet(Resume r) {
        if (r.equals(storage.get(r.getUuid()))) {
            return r;
        }
        return null;
    }

    @Test
    public void get() {
        Assert.assertSame(assertGet(RESUME_1), storage.get(UUID_1));
        Assert.assertSame(assertGet(RESUME_2), storage.get(UUID_2));
        Assert.assertSame(assertGet(RESUME_3), storage.get(UUID_3));
    }

    @Test
    public void delete() {
        storage.delete(UUID_3);
        Assert.assertEquals(assertSize(2), storage.size());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(assertSize(3), storage.size());
    }

    public int assertSize(int expCount) {
        if (expCount == storage.size()) {
            return expCount;
        }
        return -1;
    }

    @Test
    public void size() {
        Assert.assertEquals(assertSize(3), storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            storage.clear();
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflowed ahead of time");
        }
        storage.save(RESUME_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(UUID_NOT_EXIST));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }
}