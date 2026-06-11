package Week10.Takehome.maps;

import Week10.Takehome.weather.WeatherRecord;

/**
 * A generic binary search tree that maps keys to values.
 *
 * Keys must implement Comparable so the tree can maintain sorted order
 * using compareTo() for all insert and lookup operations.
 *
 * Your job is to implement the four methods defined in TreeMapInterface.
 * The Node inner class and addBalanced() method are provided for you.
 *
 * @param <K> the key type; must implement Comparable
 * @param <V> the value type
 */
public class TreeMap<K extends Comparable<K>, V> implements OrderedMap<K, V> {

    private Node root;
    private int size;

    /**
     * Constructs an empty TreeMap.
     */
    public TreeMap() {
        root = null;
        size = 0;
    }

    // -----------------------------------------------------------------------
    // Your implementation goes here
    // -----------------------------------------------------------------------

    /**
     * Adds a key-value pair to the tree in BST order.
     * If the key already exists, the tree is not modified.
     *
     * Hint: compare keys using compareTo(), not == or <.
     * Hint: this follows the same recursive pattern as add() in our class BST.
     *
     * @param key   the key to insert
     * @param value the value to associate with the key
     * @return true if inserted, false if the key already existed
     */
    @Override
    public boolean add(K key, V value) {
        // TODO: implement
        if(root == null){
            root = new Node(key,value);
            size ++;
            return true;
        }

        return add(key, value, root);
    }

    public boolean add(K key, V value, Node current){
        if(key.compareTo(current.key) == 0){
            return false;
        }
        else if(key.compareTo(current.key) > 0){
            if(current.right == null){
                current.right = new Node(key, value);
                size++;
                return true;
            }

            return add(key, value, current.right);

        } else {
            if(current.left == null){
                current.left = new Node(key, value);
                size++;
                return true;
            }
            return add(key, value, current.left);
        }
    }

    /**
     * Returns the value associated with the given key, or null if not found.
     *
     * Hint: this follows the same recursive pattern as contains() in our class BST,
     * but instead of returning true/false, return the value when the key matches.
     *
     * @param key the key to search for
     * @return the associated value, or null if not found
     */
    @Override
    public V get(K key) {
        // TODO: implement
        if(root == null){
            return null;
        }

        return get(key, root);
    }

    public V get(K key, Node current){
        if (key.compareTo(current.key) == 0){
            return current.value;
        } else if (key.compareTo(current.key) > 0){
            return get(key, current.right);
        } else if (key.compareTo(current.key) < 0){
            return get(key, current.left);
        } else {
            return null;
        }
    }

    /**
     * Returns true if the tree contains the given key.
     *
     * Hint: once get() is working, this becomes very short.
     *
     * @param key the key to search for
     * @return true if found, false otherwise
     */
    @Override
    public boolean containsKey(K key) {
        // TODO: implement
        if(root == null){
            return false;
        }

        return containsKey(key, root);
    }

    public boolean containsKey(K key, Node current){
        if (key.compareTo(current.key) == 0){
            return true;
        } else if (key.compareTo(current.key) > 0){
            return containsKey(key, current.right);
        } else if (key.compareTo(current.key) < 0){
            return containsKey(key, current.left);
        }

        return false;
    }

    /**
     * Returns true if the tree contains at least one entry with the given value.
     *
     * Hint: you cannot use BST ordering here — values are not sorted.
     * You will need to visit every node in the tree.
     * Think about how to do that recursively.
     *
     * @param value the value to search for
     * @return true if found, false otherwise
     */
    @Override
    public boolean containsValue(V value) {
        // TODO: implement
        if(root == null){
            return false;
        }

        return containsValue(value, root);
    }

    public boolean containsValue(V value, Node current){
        if(current == null){
            return false;
        }

        if(current.value.equals(value)){
            return true;
        }

        return containsValue(value, current.left) || containsValue(value, current.right);
    }

    // -----------------------------------------------------------------------
    // Provided — do not modify
    // -----------------------------------------------------------------------

    /**
     * Inserts an array of key-value pairs into the tree in a balanced order.
     *
     * If keys are added in sorted order (e.g. 1946, 1947, 1948...) the tree
     * degenerates into a straight line and loses all its efficiency benefits.
     * This method avoids that by sorting the keys and inserting the middle
     * element first, recursively — producing a balanced tree.
     *
     * Always use this method instead of calling add() in a loop when loading
     * data from a file.
     *
     * @param keys   array of keys to insert, in any order
     * @param values array of values corresponding to each key
     */
    public void addBalanced(K[] keys, V[] values) {
        for (int i = 1; i < keys.length; i++) {
            K tempKey = keys[i];
            V tempVal = values[i];
            int j = i - 1;
            while (j >= 0 && keys[j].compareTo(tempKey) > 0) {
                keys[j + 1] = keys[j];
                values[j + 1] = values[j];
                j--;
            }
            keys[j + 1] = tempKey;
            values[j + 1] = tempVal;
        }
        addBalanced(keys, values, 0, keys.length - 1);
    }

    private void addBalanced(K[] keys, V[] values, int low, int high) {
        if (low > high) return;
        int mid = (low + high) / 2;

        //NOTE: This calls your add() method above!
        add(keys[mid], values[mid]);

        addBalanced(keys, values, low, mid - 1);
        addBalanced(keys, values, mid + 1, high);
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        return "TreeMap[root=" + root + ", size=" + size + "]";
    }

    // -----------------------------------------------------------------------
    // Inner Node class — provided, do not modify
    // -----------------------------------------------------------------------

    /**
     * A single node in the TreeMap.
     * Holds a key-value pair and references to its left and right children.
     *
     * This is the same structure as the Node in our class BST, extended to
     * hold a key and a value instead of a single integer.
     */
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key   = key;
            this.value = value;
            this.left  = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}