package bag;

import java.util.Arrays;

public class Bag<T> implements Collection<T> {
    private static final int DEFAULT_CAP = 10;

    private T[] items;
    private int size;
    private int nextIndex; //holds next empty spot

    public Bag() {
        //you can't instantiate type T (we don't know what the constructors look like)
        //T myNewObj = new T();

        //you can't instantiate an array of type T (so you never place anything but an object
        //of type T in the array)
        items = (T[])new Object[10];
    }

    public Bag(int capacity) {
        items = (T[])new Object[capacity];
    }

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
     */
    public int capacity() {
        return items.length;
    }

    /**
     * Returns the number of elements in the Bag
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getSomething() {
        //just hand them the first item in the bag
        if (items[0] != null) {
            return items[0];
        }
        return null;
    }

    public boolean contains(T obj) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

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

                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        size = 0;
        nextIndex = 0;
    }

    /**
     * Overrides Object.toString() and shows
     * the elements in the bag.
     */
    public String toString() {
        //static method on the Arrays class
        return Arrays.toString(items);
    }
}
