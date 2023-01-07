package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        int i = 0;
        while ((i < size) && (storage[i].compareTo(r) < 0)) {
            i++;
        }
        for (int j = size; j > i; j--) {
            storage[j] = storage[j - 1];
        }
        storage[i] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        for (int j = getIndex(uuid); j < size; j++) {
            storage[j] = storage[j + 1];
        }
        size--;

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


}
