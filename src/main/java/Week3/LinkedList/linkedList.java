package Week3.LinkedList;

public class linkedList {
    //access to all nodes through the first node
    private Node head;
    private Node tail;
    private int size;

    public linkedList() {

    }

    public void add(Object obj) {
        //if the list is empty, add the first element
        if (head == null) {
            head = new Node(obj);
            tail = head;
        } else {
            //use tail to immediately get to the end of the list
            tail.next = new Node(obj);
            tail = tail.next;
        }
        size++;
    }

    public Object get(int index) {
        indexCheck(index);
        Node found = getNodeAtIndex(index);
        return found.data;
    }

    public Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i <= index - 1; i++) {
            current = current.next;
        }

        return current;
    }

    public void indexCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Bad index");
        }
    }

    //replace the value at the position - index
    public void set(int index, Object newElem) {
        indexCheck(index);
        Node found = getNodeAtIndex(index);
        found.data = newElem;
    }

    //returns true if obj is in the list, otherwise false
    public boolean contains(Object obj) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(obj)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    //print out the linked list in the format head -> A -> B -> C -> D -> null
    public void printList() {
        if (head == null) {
            System.out.println("head -> null");
            return; //exit
        }

        System.out.print("head -> ");

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean removeFirst() {
        if (head == null) return false;
        head = head.next; //move head to the second element
        size--;
        return true;
    }

    public boolean removeLast() {
        //1. check if list is empty
        if (head == null) return false;

        //1.5 check if one element in the LL
        if (head.next == null) {
            head = null;
            size = 0;
            return true;
        }

        //2. find the last node...
        Node current = head;
        while (current.next.next != null) {
            //moves one node ahead in the list
            current = current.next;
        }

        //3. remove it
        current.next = null;
        size--;

        return true;
    }

    public boolean remove(Object obj) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //a nested (inner) class
    public class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
