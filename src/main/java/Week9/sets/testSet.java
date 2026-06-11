package Week9.sets;

public class testSet {
    public static void main(String[] args){
        String[] fruits = {"Apple", "Banana", "Orange", "Kiwi", "Peach", "Pineapple"};
        String[] otherFruits = {"Banana", "Melon", "Apple", "Pear"};

        Set mySet = new Set();
        Set otherSet = new Set();

        //System.out.println(mySet);

        for(String fruit : fruits){
            mySet.add(fruit);
        }
        System.out.println(mySet);

        for(String fruit : otherFruits){
            otherSet.add(fruit);
        }
        System.out.println(otherSet);

        /*
        mySet.remove("Pineapple");
        System.out.println(mySet);
        //mySet.add("Grape");
        mySet.add("Watermelon");*/

        System.out.println(mySet.contains("Kiwi"));
        System.out.println(mySet.contains("Grape"));

        //mySet.remove("Pineapple");
        //System.out.println(mySet);

        Set union = mySet.union(otherSet);
        System.out.println(union);
    }
}
