package Week3.LinkedList;

public class linkedList {
    //access to all nodes through the first node
    private Node head;
    private int size;

    public linkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void add(Object obj) {
        //if the list is empty, add the first element
        if (head == null) {
            head = new Node(obj);
        } else {
            //use another variable, don't alter "head" reference
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(obj);
        }
    }

    //returns true if obj is in the list, otherwise false
    public boolean contains(Object obj) {
        return false;
    }

    //print out the linked list in the format head -> A -> B -> C -> D -> null
    public void printList() {

    }

    public Object get(int index){
        indexCheck(index);

        Node current = head;
        for(int i = 0; i <= index - 1; i++){
            current = current.next;
        }

        return current.data;
    }

    /*
    public void set(int index, Object newElement){
        indexCheck(index);

        Node found = get;

        found.data = ;
    } */

    public Node getNodeAtIndex(int index){
        Node current = head;

        for(int i = 0;i <= index -1 ;i++){
            current = current.next;
        }

        return current;
    }

    public void indexCheck(int index){
        if(size < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
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
