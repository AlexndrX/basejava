package com.urise.webapp.storage;

import com.urise.webapp.storage.serialisation.ObjectStreamStrategy;

public class ObjectStreamPathTest extends AbstractStorageTest {

    public ObjectStreamPathTest() {
        super(new PathStorage(STORAGE_PATH, new ObjectStreamStrategy()));
    }
}
