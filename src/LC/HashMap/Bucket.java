package LC.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bucket<K, V> {
    private List<Cell<K, V>> cells;
    public Bucket() {
        cells = new ArrayList<>();
    }
    public V get(K key) {
        for (Cell c : cells) {
            if (c.keyEquals(key)) {
                return (V) c.getValue();
            }
        }
        return null;
    }
    public void put(K key, V val) {
        for (Cell c : cells) {
            if (c.keyEquals(key)) {
                c.setValue(val);
                return;
            }
        }
        this.cells.add(new Cell<K, V>(key,val));
    }
    public boolean remove(K key) {
        Cell swapMe = null;
        for (Cell c : cells) {
            if (c.keyEquals(key)) {
                swapMe = c;
                break;
            }
        }
        if (swapMe == null) {
            return false;
        }
        Cell lastCell = cells.get(cells.size() - 1);
        swapMe.setKey(lastCell.getKey());
        swapMe.setValue(lastCell.getValue());
        cells.remove(cells.size() - 1);
        return true;

    }

    public List<Cell<K, V>> getCells() {
        return cells;
    }
}
