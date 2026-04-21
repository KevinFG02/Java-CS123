package Week2.Friday.List;

public class TestArrayList {
    public static void main(String[] args){
        ArrayList<Integer> testArray = new ArrayList<>();

        testArray.add(12);
        testArray.add(4);
        testArray.add(1678);
        testArray.add(62);

        System.out.println("First: " + testArray.getFirst());
        System.out.println("Last: " + testArray.getLast());
        System.out.println(testArray);

        testArray.addFirst(1);
        testArray.addLast(1234);
        System.out.println(testArray);

        testArray.removeFirst();
        testArray.removeLast();
        System.out.println(testArray);
    }
}
