package es.urjc.grafo.EDA.mapas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;


/**
 * Separate chaining table implementation of hash tables.
 */
public class MapaEncadenamientoSeparado<K, V> extends AbstractMapa<K, V> {

    private ArrayList<MapEntry<K, V>>[] table;

    /**
     * Creates a hash table
     */
    public MapaEncadenamientoSeparado() {
        this(999983, CAPACITY);
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public MapaEncadenamientoSeparado(int cap) {
        this(999983, cap);
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p   prime number
     * @param cap initial capacity
     */
    public MapaEncadenamientoSeparado(int p, int cap) {
        super(p, cap);
        table = new ArrayList[cap];
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
        return key == null ? 0 : Math.abs(((a * key.hashCode() + b) % prime) % this.table.length);
    }

    @Override
    public Iterable<Map.Entry<K, V>> entries() {
        return new EntryIterable();
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Encuentra y devuelve el índice de una lista en el que se encuentra una clave dada.
     * Si tenemos una lista de entradas de mapa (MapEntry) y una clave, esta función recorre la lista
     * y devuelve el índice de la entrada que tiene la clave especificada. Si no se
     * encuentra la clave, devuelve -1.
     * Por ejemplo, dada la lista [(A, V), (B, V), (C, V)] y la clave B, la función devolverá 1,
     * ya que la entrada con clave B se encuentra en el índice 1.
     *
     * @param bucket
     * @param key
     * @return
     */
    private int find(ArrayList<MapEntry<K, V>> bucket, K key) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private boolean needToResize() {
        return size >= this.table.length / 2;
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        ArrayList<MapEntry<K, V>> bucket = this.table[hashValue(key)];
        V toReturn = null;
        if (bucket != null) {
            int index = find(bucket, key);
            if (index != -1) {
                toReturn = bucket.remove(index).getValue();
                size--;
            }
        }
        return toReturn;
    }

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.  More formally, returns {@code true} if and only if
     * this map contains a mapping for a key {@code k} such that
     * {@code Objects.equals(key, k)}.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key
     */
    public boolean containsKey(K key) {
        ArrayList<MapEntry<K, V>> bucket = table[hashValue(key)];
        if (bucket != null) {
            int index = find(bucket, key);
            return index != -1;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (V v : this.values()) {
            if (v.equals(value)) return true;
        }
        return false;
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     *
     * @param desiredCapacity
     */
    private void rehash(int desiredCapacity) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {

        private int currentBucket = -1;
        private Iterator<MapEntry<K, V>> iteratorCurrentBucket;

        public EntryIterator() {
            // Find first non-empty bucket
            findNextBucket();
        }

        private void findNextBucket() {
            do {
                currentBucket++;
            } while (currentBucket < table.length && (table[currentBucket] == null || table[currentBucket].isEmpty()));
            if (currentBucket < table.length) {
                // Found a non-empty bucket
                this.iteratorCurrentBucket = table[currentBucket].iterator();
            }
        }

        public boolean hasNext() {
            return this.iteratorCurrentBucket.hasNext();
        }

        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Map.Entry<K, V> entry = this.iteratorCurrentBucket.next();
            if (!this.iteratorCurrentBucket.hasNext()) {
                findNextBucket();
            }
            return entry;
        }

    }

    private class EntryIterable implements Iterable<Map.Entry<K, V>> {

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

    }
}
