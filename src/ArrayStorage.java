import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int currentIndex = -1;

    void clear() {
        for (int i =0; i <= currentIndex; i++) {
            storage[i] = null;
        }
        currentIndex = -1;
    }

    void save(Resume r) {
        currentIndex++;
        storage[currentIndex] = r;
    }

    Resume get(String uuid) {
        int i  = 0;
        while (i <= currentIndex && !storage[i].uuid.equals(uuid)) {
            i++;
        }
        if (i == currentIndex + 1)
            return null;
        else
            return storage[i];
    }

    void delete(String uuid) {
        int i  = 0;
        while (i <= currentIndex && !storage[i].uuid.equals(uuid)) {
            i++;
        }
        if (i != currentIndex + 1) {
            for (int j = i; j < currentIndex; j++)
                storage[j] = storage[j + 1];
            storage[currentIndex] = null;
            currentIndex--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,currentIndex + 1);
    }

    int size() {
        return currentIndex + 1;
    }
}
