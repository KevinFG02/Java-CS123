package Week11.Final.bst;

public class Main {

    // -------------------------------------------------------
    // main — complete the sections marked TODO
    // -------------------------------------------------------
    public static void main(String[] args) {

        BST tree = new BST();

        // TODO: Insert a set of integers that produces a
        //       reasonably balanced tree (not a straight line).
        //       Think carefully about insertion order — the
        //       first value you insert becomes the root.
        tree.add(12);
        tree.add(2);
        tree.add(3);
        tree.add(20);
        tree.add(19);
        tree.add(1);
        tree.add(50);
        tree.add(3);

        // TODO: Print the tree sideways and verify it looks balanced.
        tree.printSideways();

        // TODO: Print the size and verify it matches the number of
        //       values you inserted.
        System.out.println(tree.size());

        // TODO: Test contains() and containsRec() with at least
        //       two values that ARE in the tree and two that are NOT.
        //       Both methods must return the same result for every test.

        System.out.println(tree.contains(3));
        System.out.println(tree.containsRec(1));
        System.out.println(tree.contains(5));
        System.out.println(tree.containsRec(5));

    }
}
