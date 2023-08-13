package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ArrayStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    //private  static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();
    private  static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid3");
        final Resume r4 = new Resume("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        printAll();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.save(r2);
        printAll();

        ARRAY_STORAGE.save(r4);
        printAll();

        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.update(r2);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();


        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
