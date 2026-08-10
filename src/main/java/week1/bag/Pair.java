package week1.bag;

/**
 * A Pair object containing doubles as parameters.
 *
 * @author Kevin Flores=Gonzalez
 * @param <D1>
 * @param <D2>
 * @version 1.0
 */
public class Pair<D1,D2>{
    private D1 first;
    private D2 second;

    /**
     * Constructor for the Pair object.
     *
     * @param first
     * @param second
     */
    public Pair(D1 first, D2 second){
        this.first = first;
        this.second = second;
    }

    /**
     * Getter for the first double.
     *
     * @return returns an object.
     */
    public D1 getFirst(){return this.first;}

    /**
     * Setter for the first double.
     *
     * @param first A parameter that contains the first double.
     */
    public void setFirst(D1 first){ this.first = first;}

    /**
     * Getter for the second double.
     *
     * @return returns an object.
     */
    public D2 getSecond(){return this.second;}

    /**
     * Setter for the second double.
     *
     * @param second A parameter that contains the second double.
     */
    public void setSecond(D2 second){ this.second = second;}

    @Override
    public String toString(){
        return "First: " + first + " Second: " + second;
    }
}
