package week1.bag;

/**
 * Testing a Pair object that divides a number with another.
 * @author Kevin Flores-Gonzalez
 *
 * @version 1.0
 */
public class MainPair {
    public static void main(String[] args){
        Pair<Double,Double> pair1 = new Pair<>(43.2,23.4);

        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        System.out.println(divisionDecimals(pair1.getFirst(), pair1.getSecond()));

        Pair<Double, Double> pair2 = divisionDecimals(9, 4);
        System.out.println(pair2);
    }

    /**
     * A pair object that divides a double with another double.
     *
     * @param first A double that will be divided by the second double.
     * @param second A double used to divide the first double.
     * @return returns a Pair object.
     */
    public static Pair<Double,Double> divisionDecimals(double first, double second){
        if (second == 0) throw new ArithmeticException("Unable to divide. Can't divide by zero.");

        double division = first / second;
        double remainer = first % second;

        return new Pair<>(division,remainer);
    }
}
