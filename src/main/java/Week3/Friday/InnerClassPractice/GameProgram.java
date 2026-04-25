package Week3.Friday.InnerClassPractice;

public class GameProgram {
    public static void main(String[] args){
        Game adventureGame = new Game("Forest", 2);
        Game scifiGame = new Game("Spaceship", 1);

        //Game.Player player1 = adventureGame.new Player("Daniel", 123); <- If static isn't used on the player inner class,
        //Game.Player player2 = scifiGame.new Player("Bob", 12);

        /* Used if the Player class isn't private.
        Game.Player player1 = new Game.Player("Daniel", 123);
        Game.Player player2 = new Game.Player("Bob", 12);
        player1.playerLocation();
        player2.playerLocation();
        */

        adventureGame.addPlayer();
    }
}
