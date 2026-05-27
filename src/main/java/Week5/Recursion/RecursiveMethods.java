package Week5.Recursion;

public class RecursiveMethods {
    public static void main(String[] args){
        printDividerRec(30);
        printDown(5);
        System.out.println(returnDividerRec(5));
    }

    //---------------------------------------------
    // my comment here
    //---------------------------------------------

    public static void printDividerRec(int numDashes) {
        if (numDashes == 0) {
            System.out.println(); //just a new line
            return;
        }

        System.out.print("-");
        printDividerRec(numDashes - 1);
    }

    private static String returnDividerRec(int numDashes) {
        if (numDashes == 0) {
            return "";
        }

        return "-" + returnDividerRec(numDashes - 1);
    }

    public static void printDivider(int numDashes) {
        for (int i = 1; i <= numDashes; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static String returnDivider(int numDashes) {
        String output = "";
        for (int i = 1; i <= numDashes; i++) {
            output += "-";
        }
        return output;
    }

    //print from num down to 1
    public static void printDown(int num) {
        if (num < 0) throw new IllegalArgumentException("Positive numbers only!");

        //base case?
        if (num == 1) {
            System.out.println(num);
        } else {
            printDown(num - 1);
            System.out.println(num);
        }
    }

    //prints from the number given to zero (either up or down)
    public static void printToZero(int num) {
        if (num == 0) {
            System.out.println(num);
            return;
        }

        if (num < 0) {
            System.out.println(num);
            printToZero(num+1);
        } else if (num > 0) {
            System.out.println(num);
            printDown(num-1);
        }
    }
}
