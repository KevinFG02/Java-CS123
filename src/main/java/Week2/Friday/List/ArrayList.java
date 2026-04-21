package Week2.Friday.List;

import java.util.*;

public class ArrayList<T> implements Collection<T>, List<T> {
    private static final int INITIAL_CAPACITY = 5;

    private T[] data;
    private int size; //AKA nextIndex...

    public ArrayList() {
        data = (T[])new Object[INITIAL_CAPACITY];
    }

    public boolean add(T newElem) {
        //detect if the array is full
        if (data.length == size) {
            resize();
        }

        data[size] = newElem;
        size++;
        return true;
    }

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
     * Inserts an element at a position in the internal array,
     * and shifts elements out of the way to make room for it.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
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

    public T get(int index) {
        validateIndex(index);
        return data[index];
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    //returns the old value after replacing it
    public T set(int index, T element) {
        validateIndex(index);

        T oldValue = data[index];
        data[index] = element; //replaces the old value in the list
        return oldValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object other) {
        //loop over the "filled" part of the list
        for (int i = 0; i < size; i++) {
            if (other.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        //clear out the array
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        //update our bookkeeping values
        size = 0;
    }

    public boolean remove(Object search) {
        int index = findObjectIndex(search);
        if (index == -1) return false;

        remove(index);
        return true;
    }

    private int findObjectIndex(Object search) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(search)) {
                return i; //found!
            }
        }
        return -1; //not found!
    }

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

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return data[0];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return data[size-1];
    }

    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    @Override
    public void addLast(T element) {
        add(element);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty.");
        }

        return remove(0);
    }

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
