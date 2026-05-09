package Week5.FridayLab;

import java.util.HashMap;
import java.util.Map;

public class PracticeProblem {
    public static Map<Integer, Integer> mapFib = new HashMap<>();

    public static void main(String[] args){
        System.out.println("Fib3: " + fib(3));
        System.out.println("Fib6: " + fib(6));
        System.out.println("Fib8: " + fib(8));
        System.out.println("Fib9: " + fib(9));
        System.out.println("Fib20: " + fib(20));
        System.out.println("Fib30: " + fib(30));
        System.out.println("Fib50: " + fib(50));
    }

    public static int fib(int num){
        if(num < 0) throw new ArithmeticException("Invalid Number");

        if(num <= 1){
            return num;
        }

        //int fibM1 = fib(num - 1);
        //int fibM2 = fib(num - 2);

        int fibM1 = findFib(num - 1);
        int fibM2 = findFib(num - 2);

        int finN = fibM2 + fibM1;
        return finN;
    }

    public static int findFib(int index){
        if(mapFib.containsKey(index)){
            return mapFib.get(index);
        } else {
            int number = fib(index);
            mapFib.put(index, number);
            return number;
        }
    }
}
