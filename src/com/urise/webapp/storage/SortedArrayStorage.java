package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(int index, Resume r){
        int i = 0;
        while ((i < size) && (storage[i].compareTo(r) < 0)) {
            i++;
        }
        for (int j = size; j > i; j--) {
            storage[j] = storage[j - 1];
        }
        storage[i] = r;
    }

    @Override
    protected void fillDeletedElement(int index){
        for (int j = index; j < size; j++) {
            storage[j] = storage[j + 1];
        }
    }

     @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
