package dataStructures;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newEntry;
        } else {
            Entry<K, V> current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
            }
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
}