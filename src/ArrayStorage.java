import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int count = 0;

    void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                return storage[i];
            }
        }
        Resume tempDummy = new Resume();
        tempDummy.uuid = "dummy";
        return tempDummy;
    }

    void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;

                for (int j = i + 1; j < count; j++) {
                    storage[j - 1] = storage[j];
                    storage[j] = null;
                }
                break;
            }
        }
        count--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] fullStorage = new Resume[count];
        for (int i = 0; i < count; i++) {
            fullStorage[i] = storage[i];
        }
        return fullStorage;
    }

    int size() {
        return count;
    }
}
