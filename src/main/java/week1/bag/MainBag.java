package week1.bag;

/**
 * Testing a bag data structure from class.
 * @author Kevin Flores-Gonzalez
 *
 * @version 1.0
 */
public class MainBag {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>(5);
        // Bag<Boolean> bagOfFlags = new Bag<Boolean>(3);

        bag.add("socks");
        bag.add("shirt");
        bag.add("hat");
        bag.add("shorts");
        bag.add("shoes");

        boolean added = bag.add("belt"); // There should not be room.
        if (!added) {
            System.out.println("Bag is full!");
        }

        System.out.println("Capacity: " + bag.capacity());
        System.out.println("Size: " + bag.size());
        System.out.println(bag);

        //try removing an element
        bag.remove("shirt");
        bag.remove("shorts");
        System.out.println(bag);

        String thing = bag.getSomething();
        System.out.println(thing);

        System.out.println(bag.size());

        /*
        // Testing different data types.
        bag.add(13);
        bag.add(7);
        bag.add(42);

        bag.remove(42);
        */
    }
}
