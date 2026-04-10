package Week1.Friday;

import java.util.List;
import java.util.LinkedList;

// Kevin Flores
// 4/10/26
// CS123

public class Lists {
    public static void main(String[] args){
        List<String> list1 = new LinkedList<>();

        list1.add("Apple");
        list1.add("Orange");
        list1.add("Banana");

        for(int i = 0; i < list1.size(); i++){
            String fruit = list1.get(i);
            System.out.println(fruit);
        }

        list1.remove("Apple");
        System.out.println(list1);

        list1.clear();
        System.out.println(list1);
    }
}
