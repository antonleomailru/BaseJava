package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int sizeOfStorage = 0;

    Boolean find(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    Integer findPosition(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return (i);
            }
        }
        return null;
    }

    public void update(String uuid, String newUuid) {
        if (find(uuid)) {
            storage[findPosition(uuid)].setUuid(newUuid);
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
        if (find(r.getUuid())) {
            System.out.println("com.urise.webapp.model.Resume: " + r.getUuid() + " alredy exist");
        } else if (sizeOfStorage == 10000) {
            System.out.println("Storage OverFlow");
        } else {
            sizeOfStorage++;
            storage[sizeOfStorage - 1] = r;
        }
    }

    public Resume get(String uuid) {
        if (find(uuid)) {
            for (Resume r : storage) {
                if (r == null || r.getUuid() == uuid) return r;
            }
        } else {
            System.out.println("com.urise.webapp.model.Resume: " + uuid + " not find");
        }
        return null;
    }

    public void delete(String uuid) {
        if (find(uuid)) {
            for (int i = 0; i < sizeOfStorage; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    sizeOfStorage--;
                    storage[i] = storage[sizeOfStorage];
                    storage[sizeOfStorage] = null;
                }
            }
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
