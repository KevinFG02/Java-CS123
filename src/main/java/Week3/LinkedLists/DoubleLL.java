package Week3.LinkedLists;

public class DoubleLL<T> {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLL() {

    }

    public void add(T element) {
        if (head == null) {
            head = tail = new Node(element);
        } else {
            //add to the end
            Node newNode = new Node(element);
            tail.next = newNode; //point old end of the list to new node
            newNode.prev = tail; //point new node to old end of list
            tail = tail.next;    //point tail to the new end of the list
        }
        size++;
    }

    public void addFirst() {

    }

    public boolean removeFirst() {
        return false;
    }

    public void addLast() {

    }

    public boolean removeLast() {
        return false;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(T search) {
        return false;
    }

    public boolean remove(T search) {
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("head -> null");
            return; //exit
        }

        System.out.print("head -> ");

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return " <- " + data.toString() + " -> ";
        }
    }
}
