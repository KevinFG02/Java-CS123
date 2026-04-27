package Week3.LinkedList;

import java.util.LinkedList;

public class testList {
    public static void main(String[] args) {
        LinkedList colors = new LinkedList();

        colors.add("blue");
        colors.add("pink");
        colors.add("orange");
        colors.add("chartruese");
        colors.add("purple");

        for (int i = 1; i <= 100; i++) {
            colors.add("gray");
        }
        System.out.println(colors);
    }
}
