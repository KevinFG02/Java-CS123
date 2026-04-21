package Week1.BagPractice.bag;

public class Pair<D1,D2>{
    private D1 first;
    private D2 second;

    public Pair(D1 first, D2 second){
        this.first = first;
        this.second = second;
    }

    public D1 getFirst(){return this.first;}

    public void setFirst(D1 first){ this.first = first;}

    public D2 getSecond(){return this.second;}

    public void setSecond(D2 second){ this.second = second;}

    //Incomplete
    public Pair<Double,Double> divisionDecimals(double first, double second){
        double division = first / second;
        double remainer = first % second;

        return new Pair<>(division,remainer);
    }

    @Override
    public String toString(){
        return "First: " + first + " Second: " + second;
    }

}
