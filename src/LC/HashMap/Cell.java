package LC.HashMap;

public class Cell<K, V> {
    private K key;
    private V value;
    public Cell(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public boolean keyEquals(K thatKey) {
        if (thatKey == null) {
            return this.key == null;
        }
        return thatKey.equals(this.key);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
