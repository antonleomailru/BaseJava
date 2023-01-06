package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

     private Integer getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume r) {
         Integer index = getIndex(r.getUuid());
             if (index != -1) {
                 storage[index] = r;
             } else {
                 System.out.println("Resume: " + r.getUuid() + " not find");
             }

    }

    public void clear() {
        Arrays.fill(storage,0, size-1,null);
        size = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume: " + r.getUuid() + " alredy exist");
        } else if (size == storage.length) {
            System.out.println("Storage OverFlow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            return storage[getIndex(uuid)];

        } else {
            System.out.println("Resume: " + uuid + " not find");
        }
        return null;
    }

    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        if (index != -1) {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Resume: " + uuid + " not exists");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
