package week2.takehome.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A Magic Ball containing an array of values.
 *
 * @author Kevin Flores-Gonzalez
 * @param <T> Generic used in the Magic Ball object.
 * @version 1.0
 */
public class MagicBall<T> implements Ball<T> {
    private T[] values;
    private ArrayList<T> history;
    private int indexPick;

    /**
     * A constructor for the Magic Ball object.
     *
     * @param values An array of values.
     */
    public MagicBall(T[] values){
        this.values = values;
        this.history = new ArrayList<>(100);
        this.indexPick = 0;
    }

    /**
     * Getter for the array of values.
     *
     * @return returns an array.
     */
    public T[] getValues(){return values;}

    /**
     * Setter for the array of values.
     *
     * @param values An array of values.
     */
    public void setValues(T[] values){this.values = values;}

    /**
     * Getter for current ArrayList object.
     *
     * @return returns an ArrayList object.
     */
    public ArrayList<T> getHistory(){return history;}

    /**
     * Setter for an ArrayList object.
     *
     * @param history An ArrayList Object.
     */
    public void setHistory(ArrayList<T> history){this.history = history;}

    /**
     * Getter for the current index picked.
     *
     * @return returns an integer.
     */
    public int getIndexPick(){return indexPick;}

    /**
     * Setter for the current index picked.
     *
     * @param indexPick An integer.
     */
    public void setIndexPick(int indexPick){this.indexPick = indexPick;}

    @Override
    public void shake() {
        Random rand = new Random();
        indexPick = rand.nextInt(size());
        history.add(values[indexPick]);
    }

    @Override
    public T show() {
        return values[indexPick];
    }

    @Override
    public ArrayList<T> history() {
        System.out.println("History: ");
        if(history.isEmpty()){
            System.out.print(" ");
        } else {
            for(T elements : history){
               System.out.println("Shake: " + elements);
            }
        }
        return history;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public String toString(){
        return "Values:" + Arrays.toString(values);
    }
}
