import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int indexOfLastElement = -1;

    void clear() {
        for (int i = 0; i <= indexOfLastElement; i++) {
            storage[i] = null;
        }
        indexOfLastElement = -1;
    }

    void save(Resume r) {
        indexOfLastElement++;
        storage[indexOfLastElement] = r;
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r == null || r.uuid == uuid) return r;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (i <= indexOfLastElement && !storage[i].uuid.equals(uuid)) i++;
        if (i != indexOfLastElement + 1) {
            storage[i] = storage[indexOfLastElement];
            storage[indexOfLastElement] = null;
            indexOfLastElement--;
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, indexOfLastElement + 1);
    }

    int size() {
        return indexOfLastElement + 1;
    }
}
