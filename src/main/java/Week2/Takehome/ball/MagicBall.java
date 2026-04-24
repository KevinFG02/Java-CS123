package Week2.Takehome.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MagicBall<T> implements Ball<T> {
    private T[] values;
    private ArrayList<T> history;
    private int indexPick;

    public MagicBall(T[] values){
        this.values = values;
        this.history = new ArrayList<>(100);
        this.indexPick = 0;
    }

    public T[] getValues(){return values;}

    public void setValues(T[] values){this.values = values;}

    public ArrayList<T> getHistory(){return history;}

    public void setHistory(ArrayList<T> history){this.history = history;}

    public int getIndexPick(){return indexPick;}

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
