package Week4.takedown.Game;

/**
 * A class used to make an object for the JosephusGame class.
 *
 * @author Kevin Flores
 * @version 1.0
 */

public class JosephusCircle {
    private Node head;
    private Node tail;
    private Node cursor;
    private int size;
    private boolean cursorInitialize = false;

    /**
     * The default constructor for the class.
     *
     * @param playerCount Creates an object with the amount of players in the game.
     */
    public JosephusCircle(int playerCount)
    {
        //Creates a new JosephusCircle object with the maximum players given.
    }

    /**
     * Adds a player to the linked list while making a new node (tail).
     *
     * @param player an individual player.
     */
    public void addPlayer(String player)
    {
        //Adds a new player to the game from left-to-right in the internal linked list.

        if (head == null) {
            head = tail = new Node(player); // Sets the only node as both the head and tail.
        } else {
            Node addNode = new Node(player); // Makes a new node
            tail.setNext(addNode); // Sets the next field of tail to the new node;
            addNode.setPrev(tail); // Sets the prev field of the new node to tail.
            tail = addNode; // Sets the tail as the new node.
        }
        size++; // Increases the size of the linked link.

        // Activates the cursor so the moveCursor can work properly.
        if(!cursorInitialize){
            cursor = head;
            cursorInitialize = true;
        }
    }

    /**
     * Moves the current cursor to the next node (Player).
     *
     * @param direction Determines the direction the of the linked list.
     * @param steps Determines how many nodes are skipped.
     * @return a String value
     */
    public String moveCursor(Direction direction, int steps)
    {
        //Moves the current player (the cursor) from the current
        //position the given number of steps to the left or right

        /*
        // Made exclusively for the PracticeTest class. Ignore it.
        if(direction == Direction.LEFT){
            System.out.println("Moving " + steps + " to the left.");
        } else {
            System.out.println("Moving " + steps + " to the right.");
        } */

        for(int i = 1; i < steps; i++){
            if (direction == Direction.LEFT) {
                if (cursor.getPrev() != null)
                    cursor = (Node) cursor.getPrev();

                if(cursor == head){
                    cursor = tail;
                }
            } else {
                if (cursor.getNext() != null)
                    cursor = (Node) cursor.getNext();

                if(cursor == tail){
                    cursor = head;
                }
            }
        }

        // Returns the message
        return "" + cursor.getData();
    }

    /**
     * Removes the node from the linked list by reassigning the prev and next fields.
     *
     * @param direction determines the direction of the linked list.
     */
    public void removeAtCursor(Direction direction)
    {
        //Removes the player at the cursor position from the circle.

        if(cursor == null || size == 0){
            throw new NullPointerException("Message explaining what is null");
        } else if (size == 1) {
            isGameOver();
        } else {
            if(cursor == head){
                // Made exclusively for the PracticeTest class. Ignore it.
                // System.out.println("Player Removed: " + cursor.getData());
                head = (Node) cursor.getNext();
            } else if(cursor == tail){
                // Made exclusively for the PracticeTest class. Ignore it.
                // System.out.println("Player Removed: " + cursor.getData());
                tail = (Node) cursor.getPrev();
            } else {
                // Made exclusively for the PracticeTest class. Ignore it.
                // System.out.println("Player Removed: " + cursor.getData());
                cursor.getPrev().setNext(cursor.getNext());
                cursor.getNext().setPrev(cursor.getPrev());

                if(direction == Direction.LEFT){
                    cursor = (Node) cursor.getPrev();
                } else {
                    cursor = (Node) cursor.getNext();
                }
            }
        }

        // Decreases the size of the linked list.
        size--;
    }

    /**
     * Returns a string of the current players in the circle.
     *
     * @return returns a string.
     */
    public String getCircle()
    {
        //Returns a string representing the internal state of the circle,
        //with the following format:
        //<-- Player A <--> Player B <--> Player C <--> Player D -->
        String message = "";

        if (head == null) {
            message = "List is empty.";
            return message; //exit
        }

        Node current = head;

        while (current != null) {
            message += current.getData() + " <-> ";
            current = (Node) current.getNext();
        }

        return message + " null";
    }

    /**
     * Returns the boolean to determine if the game is done.
     *
     * @return returns a boolean.
     */
    public boolean isGameOver()
    {
        //Returns true if the game is over. That is, this method will
        //return true if only one player remains in the circle.
        if(size == 1){
            //System.out.println("Game is done.");
            return true;
        } else {
            //System.out.println("Game is not done. Continue playing.");
            return false;
        }
    }

    /**
     * An inner class that inherits from the JosephusNode class. Used to make nodes for the outer class.
     *
     */
    public class Node extends JosephusNode{
        public Node(Object data){
            super(data);
        }
    }
}