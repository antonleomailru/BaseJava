import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeOfStorage = 0;

    void clear() {
        for (int i = 0; i < sizeOfStorage; i++) {
            storage[i] = null;
        }
        sizeOfStorage = 0;
    }

    void save(Resume r) {
        sizeOfStorage++;
        storage[sizeOfStorage - 1] = r;
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r == null || r.uuid == uuid) return r;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (i < sizeOfStorage && !storage[i].uuid.equals(uuid)) i++;
        if (i != sizeOfStorage) {
            sizeOfStorage--;
            storage[i] = storage[sizeOfStorage];
            storage[sizeOfStorage] = null;

        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, sizeOfStorage);
    }

    int size() {
        return sizeOfStorage;
    }
}
