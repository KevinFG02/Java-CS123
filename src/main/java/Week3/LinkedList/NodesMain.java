package Week3.LinkedList;

public class NodesMain {
    static void main() {
        Node node1 = new Node("Pink");
        Node node2 = new Node("Green");
        Node node3 = new Node("Purple");
        Node node4 = new Node("Blue");

        //assemble my "linked" list
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node head = node1;

        System.out.println(node1.data); //pink
        System.out.println(head.data);  //pink

        System.out.println(node2.data);      //green
        System.out.println(head.next.data);  //green

        //just using head, print out the last color...
        System.out.println(head.next.next.next.data);
    }

}
