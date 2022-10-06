package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static com.urise.webapp.storage.ResumeTestData.createResume;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File("C:\\Users\\Professional\\IdeaProjects\\basejava\\storage");
    protected static final String STORAGE_PATH = "C:\\Users\\Professional\\IdeaProjects\\basejava\\storage\\";

    protected final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";

    private static final String FULL_NAME1 = "name1";
    private static final String FULL_NAME2 = "name2";
    private static final String FULL_NAME3 = "name3";
    private static final String FULL_NAME4 = "name4";

    private static final Resume RESUME_1 = createResume(UUID_1, FULL_NAME1);
    private static final Resume RESUME_2 = createResume(UUID_2, FULL_NAME2);
    private static final Resume RESUME_3 = createResume(UUID_3, FULL_NAME3);
    protected static final Resume RESUME_4 = createResume(UUID_4, FULL_NAME4);

    public AbstractStorageTest(Storage storage) {
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
        assertSize(0);
        Assert.assertEquals(List.of(), storage.getAllSorted());
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_2, "New Name");
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_2));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test
    public void getAllSorted() {
        assertSize(3);
        Assert.assertEquals(List.of(RESUME_1, RESUME_2, RESUME_3), storage.getAllSorted());
    }

    @Test
    public void size() {
        assertSize(3);
    }

    public void assertSize(int expCount) {
        Assert.assertEquals(expCount, storage.size());
    }

    public void assertGet(Resume r) {
        Assert.assertEquals(r, storage.get(r.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(UUID_NOT_EXIST));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }
}