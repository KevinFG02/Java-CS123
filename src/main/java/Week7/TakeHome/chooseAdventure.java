package Week7.TakeHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A "choose your own adventure" story that reads from a text file.
 *
 * @author Kevin Flores
 * @version 1.0
 */

public class chooseAdventure {
    public static void main(String[] args){
        // Create an array that contains the story
        String[] storyLines = new String[24];
        int counter = 0;

        // Read the text file
        try(Scanner reader = new Scanner(new FileInputStream("src/main/java/Week7/TakeHome/Zombies.txt"))){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                storyLines[counter] = line;
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. " + e);
        }

        //System.out.println(Arrays.toString(storyLines)); Test if the array works.
        play(0,storyLines);
    }

    public static void play(int position, String[] storyLines){
        if(position == -2){ // Base Case 1: Victory
            System.out.println("Victory!");
            System.exit(1);
        } else if(position == -1){ // Base Case 2: Death
            System.out.println("Game Over.");
            System.exit(1);
        } else {
            String originalString = storyLines[position]; // The current position

            // Creating substrings
            int indexOfSemicolon = originalString.indexOf(":");
            String currentSituation = originalString.substring(0,indexOfSemicolon);
            String choicesString = originalString.substring(indexOfSemicolon + 2);

            System.out.println(currentSituation); // Narrates the current situation

            // Splits the choices by "|"
            String[] arrayChoices = choicesString.split(" \\| ");

            int choiceCount = arrayChoices.length;
            int[] positionArray = new int[choiceCount]; // Makes an array for possible positions.
            int optionCounter = 0;

            for (String choice : arrayChoices) {
                int indexOfEqual = choice.indexOf("=");

                optionCounter++;

                String stringNum = choice.substring(indexOfEqual + 2);
                //System.out.println(stringNum); Test the substring
                int num = Integer.parseInt(stringNum);
                positionArray[optionCounter - 1] = num; // Adds the positions to the position array.

                // Slightly alters the message if the position is a negative number to avoid confusion.
                if(num >= 0){
                    System.out.println(optionCounter + ":" + choice.substring(0,indexOfEqual - 1)); // Displays all the options.
                } else {
                    System.out.println(choice.substring(0,indexOfEqual - 1));
                }
            }

            //System.out.println(Arrays.toString(positionArray)); // Test the position array

            // Prevents an out-of-bounds exception.
            if(positionArray[0] == -1 || positionArray[0] == -2){
                play(positionArray[0], storyLines);
            } else {
                // Ask for user for an integer that represents a choice.
                Scanner choiceInput = new Scanner(System.in);
                System.out.println("Pick an Integer.");
                int choiceInt = choiceInput.nextInt();

                while(choiceInt <= 0 || choiceInt > choiceCount){
                    System.out.println("Retype. Integer is either too small or too big.");
                    choiceInt = choiceInput.nextInt();
                }

                play(positionArray[choiceInt - 1], storyLines);
            }
        }
    }
}
