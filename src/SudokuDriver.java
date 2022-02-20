import random.Randomizer;
import java.io.File;
import java.util.Scanner;

public class SudokuDriver {
    public static void main(String[] args) {

        SudokuGame game;
        Scanner stdIn = new Scanner(System.in);

        if (args.length == 0) {

            Randomizer boardGen = new Randomizer(3);
            game = new SudokuGame(stdIn, boardGen.getKey(), boardGen.getRevealed());
            game.play();

        } else if (args.length == 1) {

            File seedFile = new File(args[0]);
            if (args[0].equalsIgnoreCase("-random") || args[0].equalsIgnoreCase("-r")) {
                if (String.parseInt(args[1])){
                    if ((String.parseInt(args[1]) == 4 || (String.parseInt(args[1]) == 9)) {
                    Randomizer random = new Randomizer(args[1]);
                    }
                    else {
                        System.err.println("Input Error: Type in dimension value of either 2 or 3");
                    }
                }
                else {
                    System.err.println("Input Mismatch: Type in an integer")
                }
            }
            else if (args[0].equalsIgnoreCase("-seed") || args[0].equalsIgnoreCase("-s")) {
                 if (String.parseInt(args[1])){
                    if ((String.parseInt(args[1]) == 4 || (String.parseInt(args[1]) == 9)) {
                        Randomizer random = new Randomizer(args[1]);
                        SudokuGame game = new SudokuGame(stdIn, random.getKey(), random.getRevealed());
                    }
                    else {
                        System.err.println("Input Error: Type in dimension value of either 2 or 3");
                    }
                }
                else {
                    System.err.println("Input Mismatch: Type in an integer")
                }
            }
            else if (args[0].equalsIgnoreCase("-level") || args[0].equalsIgnoreCase("-l")) {
                if (String.parseInt(args[1])){
                    if ((String.parseInt(args[1]) >= 1) || (String.parseInt(args[1]) <= 30)) {
                        SudokuGame game = new SudokuGame(stdIn, args[1]);
                    }
                    else {
                        System.err.println("Input Error: Type in a level value from 1 to 30");
                    }
                }
                else {
                    System.err.println("Input Mismatch: Type in an integer")
                }
            }
            else {
                System.err.println("Invalid Input: Type a legitimate command");
                System.exit(0);
            }
            game = new SudokuGame(stdIn, seedFile);
            game.play();

        } else {

            System.err.println();
            System.err.println("Error: Provide path to seed file, or leave blank to generate a random board.");

        } // if-else

    } // main

} // SudokuDriver
