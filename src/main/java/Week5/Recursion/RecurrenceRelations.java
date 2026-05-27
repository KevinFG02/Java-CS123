package Week5.Recursion;

public class RecurrenceRelations {
    public static void main(String[] args) {
        System.out.println("sum(1) = " + sum(1));
        System.out.println("sum(3) = " + sum(3));
        System.out.println("sum(4) = " + sum(4));
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(10) = " + sum(10));
        System.out.println("sum(100) = " + sum(100));

        System.out.println(pow3(4));

        System.out.println(mult4(6)); //4 * 6 = 24
    }

    //num(num + 1)/2
    public static int sum(int num) {
        if (num == 1) return 1;

        return sum(num - 1) + num;
    }

    public static double pow3(int exp) {
        //3^-n = 1/3^n
        if (exp < 0) return 1 / pow3(Math.abs(exp));
        if (exp == 0) return 1;

        return pow3(exp - 1) * 3;
    }

    //returns 4 * num
    public static int mult4(int num) {
        if (num == 1) return 4;

        int result = mult4(num - 1) + 4;
        return result;
    }
}
