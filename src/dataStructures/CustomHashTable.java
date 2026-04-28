package dataStructures;
import models.Student;

public class CustomHashTable {
    private static class Entry {
        String key;
        Student value;
        Entry next;

        Entry(String key, Student value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] table;
    private int size;

    public CustomHashTable() {
        table = new Entry[31]; // Prime number for better distribution
        size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(String key, Student student) {
        int index = hash(key);
        Entry entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = student;
                return;
            }
            entry = entry.next;
        }

        Entry newEntry = new Entry(key, student);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
    }

    public Student get(String key) {
        int index = hash(key);
        Entry entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }
}