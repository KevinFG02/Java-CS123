package week2.friday.list;

import java.util.*;

/**
 * Testing an Array using Generics.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> Generics for the ArrayList Object
 * @version 1.0
 */
public class ArrayList<T> implements Collection<T>, List<T> {
    private static final int INITIAL_CAPACITY = 5;

    private T[] data;
    private int size; //AKA nextIndex...

    /**
     * Constructor for Arraylist object
     */
    public ArrayList() {
        data = (T[])new Object[INITIAL_CAPACITY];
    }

    /**
     * A method that adds new elements into the ArrayList
     *
     * @param newElem An element soon to be added.
     * @return Returns a boolean if a new element was added successful.
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
     * A method that resizes the ArrayList once the ArrayList is completely filled
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
     * Inserts an element at a position in the internal array, and shifts elements out of the way to make room for it
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
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * A method that returns an element based on the selected index
     *
     * @param index index of the element to return
     * @return returns an element.
     */
    @Override
    public T get(int index) {
        validateIndex(index);
        return data[index];
    }

    /**
     * Sets an element at the selected index
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return returns ane element.
     */
    public T set(int index, T element) {
        validateIndex(index);

        T oldValue = data[index];
        data[index] = element; //replaces the old value in the list
        return oldValue;
    }

    /**
     * Determines if an index exists within the ArrayList
     *
     * @param index index of the element to return
     */
    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    /**
     * A method that returns the size of the ArrayList
     *
     * @return returns an int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * A method that determines if the ArrayList is empty
     *
     * @return returns a boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * A method that determines if an element is in the ArrayList
     *
     * @param other element whose presence in this collection is to be tested
     * @return returns a boolean
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
     * A method that clears all elements in the ArrayList
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

    /**
     * A method that removes elements in an ArrayList.
     *
     * @param search element to be removed from this collection, if present
     * @return returns a boolean
     */
    @Override
    public boolean remove(Object search) {
        int index = findObjectIndex(search);
        if (index == -1) return false;

        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);

        T result = data[index];

        //shift elements above index down
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        //clear last element
        data[size - 1] = null;
        size--;
        return result;
    }

    /**
     * A method that find a specific element in the ArrayList
     *
     * @param search An element in the ArrayList
     * @return returns an int
     */
    private int findObjectIndex(Object search) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(search)) {
                return i; //found!
            }
        }
        return -1; //not found!
    }

    /**
     * A method that gets the first object in the ArrayList.
     *
     * @return returns an object
     */
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return data[0];
    }

    /**
     * A method that gets the last object in the ArrayList.
     *
     * @return returns an object
     */
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return data[size-1];
    }

    /**
     * Adds an element at the beginning of the ArrayList.
     *
     * @param element the element to be added
     */
    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * Adds an element at the ending of the ArrayList.
     *
     * @param element the element to be added
     */
    @Override
    public void addLast(T element) {
        add(element);
    }


    /**
     * Removes the first object in the ArrayList.
     *
     * @return returns the object being removed.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return remove(0);
    }

    /**
     * Removes the last object in the ArrayList.
     *
     * @return returns the object being removed.
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return remove(size - 1);
    }

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
