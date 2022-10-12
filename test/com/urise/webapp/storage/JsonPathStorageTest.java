package com.urise.webapp.storage;

import com.urise.webapp.storage.serialisation.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_PATH, new JsonStreamSerializer()));
    }
}
