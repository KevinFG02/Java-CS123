package Week7.BinaryTree;

public class testTree {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(100, 50, 80, 200, 150, 364, 16, 811, 900, 500);

        System.out.println(tree);

        System.out.println(tree.contains(100));
        System.out.println(tree.contains(364));
        System.out.println(tree.contains(10));

        int min = tree.findMin();
        int max = tree.findMax();
        int minI = tree.iterativeMin();
        int maxI = tree.iterativeMax();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        System.out.println("MinI: " + minI);
        System.out.println("MaxI: " + maxI);

        System.out.println(tree.isLeaf(16));
        System.out.println(tree.isLeaf(50));
        System.out.println(tree.isLeaf(200));
        System.out.println(tree.isLeaf(80));

        System.out.println(tree.isInternal(16));
        System.out.println(tree.isInternal(50));
        System.out.println(tree.isInternal(200));
        System.out.println(tree.isInternal(80));
    }
}
