import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeOfStorage = 0;

    Boolean find(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    Integer findPosition(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return (i);
            }
        }
        return null;
    }

    void update(String uuid, String newUuid)  {
        if (find(uuid)) {
            storage[findPosition(uuid)].uuid = newUuid;
        } else {
            System.out.println("Resume: " + uuid + " not find");
        }
    }


    void clear() {
        for (int i = 0; i < sizeOfStorage; i++) {
            storage[i] = null;
        }
        sizeOfStorage = 0;
    }

    void save(Resume r) {
        if (find(r.uuid)) {
            System.out.println("Resume: " + r.uuid + " alredy exist");
        } else if (sizeOfStorage == 10000) {
            System.out.println("Storage OverFlow");
        } else {
            sizeOfStorage++;
            storage[sizeOfStorage - 1] = r;
        }
    }

    Resume get(String uuid) {
        if (find(uuid)) {
            for (Resume r : storage) {
                if (r == null || r.uuid == uuid) return r;
            }
        } else {
            System.out.println("Resume: " + uuid + " not find");
        }
        return null;
    }

    void delete(String uuid) {
        if (find(uuid)) {
            for (int i = 0; i < sizeOfStorage; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    sizeOfStorage--;
                    storage[i] = storage[sizeOfStorage];
                    storage[sizeOfStorage] = null;
                }
            }
        } else {
            System.out.println("Resume: " + uuid + " not exists");
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, sizeOfStorage);
    }

    int size() {
        return sizeOfStorage;
    }
}
