package week9.iterators;

import java.util.Iterator;


/**
 * A program that uses iterators on a pair of numbers.
 *
 * @author Kevin Flores-Gonzalez
 * @version 1.0
 */
public class Range implements Iterable<Integer> {
    private int min;
    private int max;

    /**
     * Constructor for Range object.
     *
     * @param min minimum number in the pair
     * @param max maximum number in the pair
     */
    public Range(int min, int max){
        //swap if out of order
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        this.min = min;
        this.max = max;
    }

    /**
     * Getter for the minimum value
     * @return Returns an integer
     */
    public int getMin(){return this.min;}

    /**
     * Setter for the minimum value
     * @param min An integer representing the minimum value
     */
    public void setMin(int min){this.min = min;}

    /**
     * Getter for the maximum value
     * @return Returns an integer
     */
    public int getMax(){return this.max;}

    /**
     * Setter for the maximum value
     * @param max An integer representing the maximum value
     */
    public void setMax(int max){this.max = max;}

    public String toString() {
        String result = "";

        for (int i = min; i <= max; i++) {
            result += i + ", ";
        }

        return result;
    }

    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    /**
     * This is a smart object that knows how to iterate over the values in the Range class.
     */
    public class RangeIterator implements Iterator<Integer> {
        //holds the current "element" to return from the iterator
        private int current;

        /**
         * Default Constructor
         */
        public RangeIterator() {
            current = min;
        }

        @Override
        public boolean hasNext() {
            if (current <= max) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Integer next() {
            //save the next value to return
            int nextValue = current;

            //move to the next value to return
            current++;

            return nextValue;
        }
    }
}
