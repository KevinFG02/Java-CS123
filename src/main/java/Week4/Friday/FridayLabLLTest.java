package Week4.Friday;

public class FridayLabLLTest {
    public static void main(String[] args){
        FridayLab linkedList = new FridayLab();
        linkedList.add("Apple", "Banana", "Orange");
        linkedList.printList();

        //linkedList.reverse();
        //linkedList.printList();

        linkedList.reverseInPlace();
        linkedList.printList();
    }
}
