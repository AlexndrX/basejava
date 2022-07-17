import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int counter = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null){
                storage[i] = null;
                counter--;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null){
                storage[i] = r;
                counter++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        try {
            for (Resume resume : storage) {
                if (resume.uuid.equals(uuid)) {
                    return resume;
                }
            }
        } catch (NullPointerException e){
            System.out.println("dummy");
        }
        return null;
    }

    void delete(String uuid) {
    OUTER: for (int i = 0; i < storage.length; i++) {
                if (storage[i].uuid.equals(uuid)){
                    storage[i].uuid = null;
                    counter--;

                    for (int j = 1; j < storage.length; j++) {
                        if (storage[j] != null){
                            storage[j -1] = storage[j];
                            storage[j] = null;
                        } else {
                            break OUTER;
                        }
                    }
                }
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] fullStorage = new Resume[counter];
        for (int i = 0; i < counter; i++) {
            fullStorage[i] = storage[i];
        }
        return fullStorage;
    }

    int size() {
        return counter;
    }
}
