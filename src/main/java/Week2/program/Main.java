package program;

import bag.Bag;
import bag.Marble;

public class Main {
    public static void main(String[] args) {
        //don't forget to include a choice for the generic type!
        Bag<String> bag = new Bag<String>(5);
        Bag<String> bagOfStrings = new Bag<String>(10);
        Bag<Marble> bagOfMarbles = new Bag<Marble>(3);
        Bag<Boolean> bagOfFlags = new Bag<Boolean>(3);

        Marble marb = new Marble("Red", 2);
        String s = new String("Hello");

        bag.add("socks");
        bag.add("shirt");
        bag.add("hat");
        bag.add("shorts");
        bag.add("shoes");

        /*bag.add(13);
        bag.add(7);
        bag.add(42);*/

        boolean added = bag.add("belt"); //there should not be room!
        if (!added) {
            System.out.println("Bag is full!");
        }

        System.out.println("Capacity: " + bag.capacity());
        System.out.println("Size: " + bag.size());

        System.out.println(bag);

        //try removing an element
        bag.remove("shirt");
        bag.remove("shorts");

        /*bag.remove(42);*/

        System.out.println(bag);

        String thing = bag.getSomething();
        System.out.println(thing);
    }
}
