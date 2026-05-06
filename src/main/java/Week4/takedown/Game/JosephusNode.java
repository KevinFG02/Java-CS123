package Week4.takedown.Game;

//A doubly-linked list node. This node class is not an inner class,
//so you will need to use getters/setters to access the fields in
//the class. They should not be public.

/**
 * A class that makes nodes for the linked list.
 *
 * @author Kevin Flores
 * @version 1.0
 */

public class JosephusNode {
    private JosephusNode next;
    private JosephusNode prev;
    private Object data;

    public JosephusNode(Object data) {this.data = data;}

    public Object getData(){return data;}

    public JosephusNode getNext(){return next;}

    public void setNext(JosephusNode next){ this.next = next;}

    public JosephusNode getPrev(){return prev;}

    public void setPrev(JosephusNode prev){this.prev = prev;}

    public String toString() {return " <- " + data.toString() + " -> ";}
}