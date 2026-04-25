package Week3.Friday.InnerClassPractice;

public class Game {
    private String map;
    private int level;
    private Player player; // Added this when the private accessor was used on the player class.

    public Game(String map, int level){
        this.map = map;
        this.level = level;
    }

    public void addPlayer(){
        player = new Player("Gelbert", 10);

        System.out.println("The player name is: " + player.name);
    }

    /* void addPlayer(){
        Player ply1 = new Player("Gelbert", 10);
        ply1.name = "John Cena";
        ply1.points = 1;
    }*/

    private static class Player {
        private String name;
        private int points;

        public Player(String name, int points){
            this.name = name;
            this.points = points;
        }

        public void playerLocation(){
            System.out.println("The player is at: ???"); // Game.this.map <- if static isn't used.
            System.out.println("The level is: ???"); // Game.this.level
        }
    }

    /*
    public static class Player {
        private String name;
        private int points;

        public Player(String name, int points){
            this.name = name;
            this.points = points;
        }

        public void playerLocation(){
            System.out.println("The player is at: ???"); // Game.this.map <- if static isn't used.
            System.out.println("The level is: ???"); // Game.this.level
        }
    }*/

    public class Score {

    }

    public class Enemy {

    }
}