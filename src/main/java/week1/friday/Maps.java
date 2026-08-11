package week1.friday;

import java.util.HashMap;
import java.util.Map;

/**
 * Testing the Map data structure
 *
 * @author Kevin Flores-Gonzalez
 *
 * @version 1.0
 */
public class Maps {
    public static void main(String[] args){
        Map<String, Integer> map1 = new HashMap<>(); //TreeMap

        map1.put("Dog", 12);
        map1.put("Cat", 9);
        map1.put("Turtle", 4);
        map1.put("Bird", 16);
        map1.put("Hamster", 2);
        map1.put("Fish", 3);
        System.out.println(map1);

        map1.put("Fish", 5);
        System.out.println(map1);

        for(String keys : map1.keySet()){
            int age = map1.get(keys);
            System.out.println("Animal: " + keys + " Age: " + age);
        }

        if(map1.containsKey("Monkey")){
            System.out.println("Monkey is in collection.");
        } else {
            System.out.println("Monkey is not in collection.");
        }
    }
}
