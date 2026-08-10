package week1.bag;

import java.util.Arrays;

/**
 * Making a bag data structure with generics from class.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> Generics used for a bag
 * @version 1.0
 */
public class Bag<T> implements Collection<T> {
    private static final int DEFAULT_CAP = 10;

    private T[] items;
    private int size;
    private int nextIndex; //holds next empty spot


    /**
     * Default Constructor for the Bag object.
     */
    public Bag() {
        //you can't instantiate type T (we don't know what the constructors look like)
        //T myNewObj = new T();

        //you can't instantiate an array of type T (so you never place anything but an object
        //of type T in the array)
        items = (T[])new Object[10];
    }

    /**
     * Default constructor for the Bag object.
     *
     * @param capacity initializes the capacity of the bag
     */
    public Bag(int capacity) {
        items = (T[])new Object[capacity];
    }

    /**
     * Adds an object to the bag.
     *
     * @param obj represents an object with a generic date type.
     * @return returns a boolean upon the method adding an element.
     */
    @Override
    public boolean add(T obj) {
        //is the bag full?
        if (nextIndex == items.length) {
            return false;
        }

        //fill the spot at nextIndex, O(1)
        items[nextIndex] = obj;
        size++;
        nextIndex++;
        return true;
    }

    /**
     * Returns the total space in the bag
     *
     * @return returns an integer.
     */
    public int capacity() {
        return items.length;
    }

    /**
     * Returns the number of elements in the Bag
     *
     * @return returns an integer.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Determines if the bag is empty.
     *
     * @return returns a boolean.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets an element from the bag.
     *
     * @return returns an object.
     */
    @Override
    public T getSomething() {
        //just hand them the first item in the bag
        if (items[0] != null) {
            return items[0];
        }
        return null;
    }

    /**
     * Determines if an object is within the bag.
     *
     * @param obj An object from the bag.
     * @return returns a boolean.
     */
    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a boolean if an object is removed from the bag successfully..
     *
     * @param search An object with the bag.
     * @return returns a boolean.
     */
    @Override
    public boolean remove(T search) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(search)) {
                //removing the element
                items[i] = null;

                //shift elements down one index
                for (int j = i; j < items.length - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[items.length - 1] = null; //clear the last item

                size--;
                return true;
            }
        }

        return false;
    }

    /**
     * Clears all objects in the bag.
     */
    @Override
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        size = 0;
        nextIndex = 0;
    }

    public String toString() {
        //static method on the Arrays class
        return Arrays.toString(items);
    }
}
