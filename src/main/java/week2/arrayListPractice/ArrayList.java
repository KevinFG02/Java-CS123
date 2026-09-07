package week2.arrayListPractice;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

/**
 * Making the ArrayList.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> Generic used for the ArrayList.
 * @version 1.0
 */
public class ArrayList<T> implements Collection<T>, List<T> {
    // Fields
    private static final int INITIAL_CAPACITY = 5;

    private T[] data;
    private int size; //AKA nextIndex...

    /**
     * Constructor for the ArrayList.
     */
    public ArrayList() {
        data = (T[])new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds a new element to the ArrayList.
     *
     * @param newElem A method to add element.
     * @return Returns a boolean
     */
    @Override
    public boolean add(T newElem) {
        //detect if the array is full
        if (data.length == size) {
            resize();
        }

        data[size] = newElem;
        size++;
        return true;
    }

    /**
     * Inserts an element at a position in the internal array,
     * and shifts elements out of the way to make room for it.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        validateIndex(index);

        //detect if the array is full
        if (data.length == size) {
            resize();
        }

        //shift elements up one index
        for (int i = size - 1; i >= index; i--) {
            data[i] = data[i + 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * A method that resizes the ArrayList if its full.
     */
    private void resize() {
        //create a new array, replace the old array
        T[] oldData = data;
        data = (T[])new Object[data.length * 2]; //increase by 100%

        //copy over all elements to the new array
        for (int i = 0; i < oldData.length; i++) {
            data[i] = oldData[i];
        }
    }

    /**
     * A method that gets the element requested.
     *
     * @param index index of the element to return
     * @return Returns the element.
     */
    @Override
    public T get(int index) {
        validateIndex(index);
        return data[index];
    }

    /**
     * A method that determines if the index is valid within the ArrayList.
     *
     * @param index An integer used as an index.
     */
    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    /**
     * Replaces an old element with another element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return Returns the old element.
     */
    @Override
    public T set(int index, T element) {
        validateIndex(index);

        T oldValue = data[index];
        data[index] = element; //replaces the old value in the list
        return oldValue;
    }

    /**
     * A method that returns the size of the ArrayList.
     *
     * @return Returns an integer.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * A method that determines if an ArrayList is empty or not.
     *
     * @return Returns a boolean.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * A method that determines if an element is in the ArrayList.
     *
     * @param other An element used to compare.
     * @return Returns a boolean.
     */
    @Override
    public boolean contains(Object other) {
        //loop over the "filled" part of the list
        for (int i = 0; i < size; i++) {
            if (other.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that clears all the elements in the ArrayList.
     */
    @Override
    public void clear() {
        //clear out the array
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        //update our bookkeeping values
        size = 0;
    }

    // Incomplete Method
    public boolean remove(Object o) {
        return false;
    }

    // Incomplete Method
    public T remove(int index) {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    //no implementations below this...
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operation not supported");
    }
}
