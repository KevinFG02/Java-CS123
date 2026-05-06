package Week4.takedown.Launch;

import Week4.takedown.Game.Direction;
import Week4.takedown.Game.JosephusCircle;
import java.util.Scanner;

/**
 * A class used to test the JosephusCircle before using the main class (JosephusGame).
 *
 * @author Kevin Flores
 * @version 1.0
 */

public class PracticeTest {
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        int players = 4;
        JosephusCircle newGame = new JosephusCircle(players);

        for (int i = 1; i <= players; i++)
        {
            newGame.addPlayer(getString("Enter player name: "));
        }

        System.out.println(newGame.getCircle());
        newGame.isGameOver();

        //System.out.println(newGame.moveCursor(Direction.LEFT, 2));
        System.out.println(newGame.moveCursor(Direction.LEFT, 6));
        //System.out.println(newGame.moveCursor(Direction.RIGHT, 3));

        newGame.removeAtCursor(Direction.LEFT);
        System.out.println(newGame.getCircle());

        newGame.removeAtCursor(Direction.LEFT);
        newGame.removeAtCursor(Direction.LEFT);
        newGame.isGameOver();
        System.out.println(newGame.getCircle());
        newGame.removeAtCursor(Direction.LEFT);
    }

    /**
     * Copied from the JosephusGame class, used to test the JosephusNode object.
     *
     * @param message the message to be printed
     */
    private static String getString(String message)
    {
        System.out.println(message);

        return console.nextLine();
    }
}
