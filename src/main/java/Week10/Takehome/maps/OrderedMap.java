package Week10.Takehome.maps;

/**
 * Defines the public contract for a generic TreeMap data structure.
 *
 * A TreeMap is a binary search tree that stores key-value pairs.
 * Keys must implement Comparable so the tree can maintain sorted order.
 *
 * This interface is complete. Do not modify it.
 *
 * @param <K> the key type; must implement Comparable
 * @param <V> the value type
 */
public interface OrderedMap<K extends Comparable<K>, V> {

    /**
     * Adds a key-value pair to the tree.
     * If the key already exists, the tree is not modified.
     *
     * @param key   the key to insert (used for ordering and lookup)
     * @param value the value to associate with the key
     * @return true if the pair was inserted, false if the key already existed
     */
    boolean add(K key, V value);

    /**
     * Returns the value associated with the given key, or null if not found.
     *
     * @param key the key to search for
     * @return the associated value, or null if the key is not in the tree
     */
    V get(K key);

    /**
     * Returns true if the tree contains the given key.
     *
     * @param key the key to search for
     * @return true if found, false otherwise
     */
    boolean containsKey(K key);

    /**
     * Returns true if the tree contains at least one entry with the given value.
     * Note: unlike the key-based methods, this requires checking every node.
     *
     * @param value the value to search for
     * @return true if found, false otherwise
     */
    boolean containsValue(V value);
}