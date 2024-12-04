package com.cwm.hashtable;

import java.util.LinkedList;

public class MyHashMap {
    private final int capacity = 10;

    private int size = 0;

    private final LinkedList<Entry>[] buckets = new LinkedList[capacity];

    public void put(int key, String value) {
        if (size == capacity)
            throw new IllegalStateException();

        int index = hash(key);

        Entry entry = new Entry(key, value);

        if (buckets[index] == null)
            createBucket(index, entry);

        else
            while (index < capacity) {
                if (buckets[index] == null) {
                    createBucket(index, entry);

                    break;
                }

                index++;
            }

        size++;
    }

    public String get(int key) {
        for (LinkedList<Entry> list : buckets) {
            if (list != null) {
                Entry entry = list.getFirst();

                if (entry.key == key)
                    return entry.value;
            }
        }

        return null;
    }

    public void remove(int key) {
        for (LinkedList<Entry> list : buckets) {
            if (list != null) {
                Entry entry = list.getFirst();

                if (entry.key == key) {
                    list.removeFirst();
                    size--;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{ ");

        for (LinkedList<Entry> list : buckets) {
            if (list != null)
                for (Entry entry : list) {
                    builder.append(entry);
                    builder.append(" ");
                }
        }

        builder.append("}");

        return builder.toString();
    }

    private int hash(int key) {
        return key % capacity;
    }

    private void createBucket(int index, Entry entry) {
        buckets[index] = new LinkedList<>();

        buckets[index].add(entry);
    }

    private record Entry(int key, String value) {

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
