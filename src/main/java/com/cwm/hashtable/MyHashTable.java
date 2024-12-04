package com.cwm.hashtable;

import java.util.LinkedList;

public class MyHashTable {

    private final int size = 5;

    private final LinkedList<Entry>[] table = new LinkedList[size];

    public MyHashTable() {
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(int key, String value) {
        Entry entry = new Entry(key, value);

        table[key % size].addLast(entry);
    }

    public String get(int key) {
        for (Entry e : table[key % size])
            if (e.key == key)
                return e.value;

        return null;
    }

    public void remove(int key) {
        table[key % size].removeIf(e -> e.key == key);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");

        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                builder.append(entry);
                builder.append(", ");
            }
        }

        builder.append("}");

        return builder.toString();
    }

    private record Entry(int key, String value) {

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }
}
