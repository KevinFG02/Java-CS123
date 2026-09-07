package week2.takehome.program;

import week2.takehome.ball.MagicBall;

/**
 * Making a magic ball with ArrayLists and generics.
 *
 * @author Kevin Flores
 * @version 1.0
 */

public class Program {
    public static void main(String[] args){
        String[] colors = {"Blue","Red","Yellow","Green","Purple","Orange","Brown","Pink"};
        String[] names = {"Jimothy", "Alex", "Jose","George","Victor"};
        Integer[] numbers = {1,23,42,455,32,13,457,2445,123,2};
        Boolean[] booleans = {true,false};

        MagicBall<String> stringArrayList;
        MagicBall<Integer> integerArrayList;
        MagicBall<Boolean> booleanArrayList;

        System.out.println("==================================================");
        System.out.println("                    MAGIC BALL                    ");
        System.out.println("==================================================");

        System.out.println("Choose a magic ball:");
        System.out.println("1. Color ball:");
        System.out.println("2. Name ball:");
        System.out.println("3. Number ball:");
        System.out.println("4. Truth ball:");
        System.out.println("5. Exit:");

        int ballChoice = Console.getInt("Type a number to pick a ball?");

        while(ballChoice < 1 || ballChoice > 5){
            System.out.println("Number out of bounds. Try Again.");
            ballChoice = Console.getInt("Type a number to pick a ball.");
        }

        while(ballChoice >= 1 && ballChoice <= 5){
            if(ballChoice == 1){
                stringArrayList = new MagicBall<>(colors);
                System.out.println("Current Ball: Color ball");
                System.out.println("Values stored: " + stringArrayList.size());
                ballActions(stringArrayList);
            } else if (ballChoice == 2) {
                stringArrayList = new MagicBall<>(names);
                System.out.println("Current Ball: Name ball");
                System.out.println("Values stored: " + stringArrayList.size());
                ballActions(stringArrayList);
            } else if (ballChoice == 3) {
                integerArrayList = new MagicBall<>(numbers);
                System.out.println("Current Ball: Number ball");
                System.out.println("Values stored: " + integerArrayList.size());
                ballActions(integerArrayList);
            } else if (ballChoice == 4) {
                booleanArrayList = new MagicBall<>(booleans);
                System.out.println("Current Ball: Truth ball");
                System.out.println("Values stored: " + booleanArrayList.size());
                ballActions(booleanArrayList);
            } else {
                System.out.println("Program ended.");
                break;
            }

            System.out.println("Choose a magic ball:");
            System.out.println("1. Color ball:");
            System.out.println("2. Name ball:");
            System.out.println("3. Number ball:");
            System.out.println("4. Truth ball:");
            System.out.println("5. Exit:");

            ballChoice = Console.getInt("Type a number to pick a ball?");

            while(ballChoice < 1 || ballChoice > 5){
                System.out.println("Number out of bounds. Try Again.");
                ballChoice = Console.getInt("Type a number to pick a ball.");
            }
        }
    }

    /**
     * Prints elements depending on the action chosen by the user.
     *
     * @param ballType the object used to print elements.
     */
    public static void ballActions(MagicBall ballType){
        System.out.println("1. Shake once:");
        System.out.println("2. Shake multiple times:");
        System.out.println("3. Show history:");
        System.out.println("4. Exit:");
        int ballAction = Console.getInt("Type a number to pick an action.");

        while(ballAction < 1 || ballAction > 4){
            System.out.println("Number out of bounds. Try Again.");
            ballAction = Console.getInt("Type a number to pick an action.");
        }

        while(ballAction >= 1 && ballAction <= 4){
            String question;

            if(ballAction == 1){
                question = Console.getString("Ask a question.");
                System.out.println(question);
                ballType.shake();
                System.out.println("Shake: " + ballType.show());
            } else if (ballAction == 2){
                question = Console.getString("Ask a question.");
                int repeatCount = Console.getInt("How many times to repeat?");

                System.out.println(question);

                for(int i = 0; i < repeatCount; i++){
                    ballType.shake();
                    System.out.println("Shake " + (i + 1)  + ": " + ballType.show());
                }
            } else if (ballAction == 3){
                ballType.history();
            } else {
                break;
            }
            System.out.println("1. Shake once:");
            System.out.println("2. Shake multiple times:");
            System.out.println("3. Show history:");
            System.out.println("4. Exit:");
            ballAction = Console.getInt("Type a number to pick an action");

            while(ballAction < 1 || ballAction > 4){
                System.out.println("Number out of bounds. Try Again.");
                ballAction = Console.getInt("Type a number to pick an action.");
            }
        }
    }
}
