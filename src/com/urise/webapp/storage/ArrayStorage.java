package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int sizeOfStorage = 0;

     Integer findPosition(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return (i);
            }
        }
        return -1;
    }

    public void update(String uuid, String newUuid) {
        Integer pos = findPosition(uuid);
        if (pos != -1) {
            storage[pos].setUuid(newUuid);
        } else {
            System.out.println("com.urise.webapp.model.Resume: " + uuid + " not find");
        }
    }

    public void clear() {
        for (int i = 0; i < sizeOfStorage; i++) {
            storage[i] = null;
        }
        sizeOfStorage = 0;
    }

    public void save(Resume r) {
        if (findPosition(r.getUuid()) != -1) {
            System.out.println("com.urise.webapp.model.Resume: " + r.getUuid() + " alredy exist");
        } else if (sizeOfStorage == storage.length) {
            System.out.println("Storage OverFlow");
        } else {
            storage[sizeOfStorage] = r;
            sizeOfStorage++;
        }
    }

    public Resume get(String uuid) {
        if (findPosition(uuid) != -1) {
            for (Resume r : storage) {
                if (r == null || r.getUuid() == uuid) return r;
            }
        } else {
            System.out.println("com.urise.webapp.model.Resume: " + uuid + " not find");
        }
        return null;
    }

    public void delete(String uuid) {
        Integer pos = findPosition(uuid);
        if (pos != -1) {
            sizeOfStorage--;
            storage[pos] = storage[sizeOfStorage];
            storage[sizeOfStorage] = null;
        } else {
            System.out.println("com.urise.webapp.model.Resume: " + uuid + " not exists");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, sizeOfStorage);
    }

    public int size() {
        return sizeOfStorage;
    }
}
