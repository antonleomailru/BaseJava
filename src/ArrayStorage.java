/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i  = 0;
        while (i < storage.length && storage[i] != null) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int i  = 0;
        while (i < storage.length && storage[i] != null) {
            i++;
        }
        storage[i] = r;
    }

    Resume get(String uuid) {
        int i  = 0;
        while (i < storage.length && storage[i] != null && storage[i].uuid != uuid) {
            i++;
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i  = 0;
        while (i < storage.length && storage[i] != null && storage[i].uuid != uuid) {
            i++;
        }
        int j  = 0;
        while (j < storage.length - 1 && storage[i] != null) {
            storage[i] = storage[i+1];
            i++;
        }
        storage[i] = null;

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int i  = 0;
        while (i < storage.length && storage[i] != null) {
            i++;
        }
        Resume[] stor = new Resume[i];
        int j  = 0;
        while (j <= i-1) {
            stor[j] = storage[j];
            j++;
        }
        return stor;
    }

    int size() {
        int i  = 0;
        while (i < storage.length && storage[i] != null) {
            i++;
        }
        return i;
    }
}
