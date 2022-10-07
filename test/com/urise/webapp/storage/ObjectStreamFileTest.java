package com.urise.webapp.storage;

import com.urise.webapp.storage.serialisation.ObjectStreamStrategy;

public class ObjectStreamFileTest extends AbstractStorageTest {

    public ObjectStreamFileTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamStrategy()));
    }
}
