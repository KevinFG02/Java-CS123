package Week3.LinkedLists;

public class testList {
    static void main() {
        LinkedList colors = new LinkedList();

        colors.add("blue");
        colors.add("pink");
        colors.add("orange");
        colors.add("chartruese");
        colors.add("purple");
        colors.add("yellow");
        colors.add("gray");

        System.out.println(colors.get(0));
        System.out.println(colors.get(4));
        System.out.println(colors.get(6));

        colors.set(0, "cyan");
        colors.set(4, "magenta");
        colors.set(6, "grey");
        colors.printList();

        //we have to be careful about using a LL optimally
        LinkedList listOfNums = new LinkedList();
        System.out.println("Adding nums");
        for (int i = 1; i < 1_000_000; i++) {
            listOfNums.add(i);
        }
        System.out.println("All done!");

        //access each element in the LL - this loop is O(n^2)
        for (int i = 0; i < listOfNums.size(); i++) {
            Object num = listOfNums.get(i);
        }
        System.out.println("Accessed all elements");
    }
}
