package Week9.Iterators;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private int min;
    private int max;

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

    public int getMin(){return this.min;}
    public void setMin(int min){this.min = min;}
    public int getMax(){return this.max;}
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
     * This is a smart object that knows how to
     * iterate over the values in the Range class.
     */
    public class RangeIterator implements Iterator<Integer> {
        //holds the current "element" to return from the iterator
        private int current;

        public RangeIterator() {
            current = min;
        }

        public boolean hasNext() {
            if (current <= max) {
                return true;
            } else {
                return false;
            }
        }

        public Integer next() {
            //save the next value to return
            int nextValue = current;

            //move to the next value to return
            current++;

            return nextValue;
        }
    }
}
