package LC.HashMap;

import com.sun.javafx.css.StyleCacheEntry;

public class MyHashMap<K,V> {
    private Bucket[] buckets;
    private int curSize = 0;
    private int capacity = 256;
    public MyHashMap() {
        buckets = new Bucket[capacity];
    }
    public V get(K key) {
        int idx = hashFunction(key);
        return (V) buckets[idx].get(key);
    }
    public void put(K key, V val) {
        int idx = hashFunction(key);
        buckets[idx].put(key, val);
        if (++curSize > capacity / 0.75) {
            rehash();
        }
    }
    public boolean remove(K key) {
        if (buckets[hashFunction(key)].remove(key)) {
            curSize--;
            return true;
        }
        return false;
    }
    private void rehash() {
        capacity *= 2;
        Bucket[] newBuckets = new Bucket[capacity];
        for (Bucket b : buckets) {
            for (Cell c : b.getCells()) {
                int idx = hashFunction(c.getKey());
                if (newBuckets[idx] == null) {
                    newBuckets[idx] = new Bucket();
                }
                newBuckets[idx].put(c.getKey(), c.getKey());
            }
        }
        buckets = newBuckets;
    }


    private int hashFunction(K key) {
        return key == null ? 0 : key.hashCode() % capacity;
    }
}
