package Week1.Friday;

import java.util.HashSet;
import java.util.Set;

// Kevin Flores
// 4/10/26
// CS123

public class Sets {
    public static void main(String[] args){
        Set<Integer> set1 = new HashSet<>(); //TreeSet

        set1.add(123);
        set1.add(121);
        set1.add(3);
        set1.add(2);
        set1.add(21);
        set1.add(3); // Ignores
        set1.add(3); // Ignores
        set1.add(12);

        System.out.println(set1.size());
        System.out.println(set1);

        for(int nums : set1){
            System.out.println(nums);
        }
    }
}
