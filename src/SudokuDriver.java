import random.Randomizer;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SudokuDriver {
    public static void main(String[] args) {

        SudokuGame game;
        Scanner stdIn = new Scanner(System.in);
        Scanner scan;

        if (args.length == 0) {

            Randomizer boardGen = new Randomizer(3);
            game = new SudokuGame(stdIn, boardGen.getKey(), boardGen.getRevealed());
            game.play();

        } else if (args.length == 1) {

            File seedFile = new File(args[0]);
            if (args[0].equalsIgnoreCase("-random") || args[0].equalsIgnoreCase("-r")) {
                try {
                    File dimension = new File(args[1]);
                    scan = new Scanner(dimension); //npe
                    if (scan.hasNextInt()){
                        if ((Integer.parseInt(args[1]) == 2 || (Integer.parseInt(args[1]) == 3))) {
                            Randomizer random = new Randomizer(Integer.parseInt(args[1]));
                            game = new SudokuGame(stdIn, random.getKey(), random.getRevealed());
                            game.play();
                        }
                        else {
                            System.err.println("Input Error: Enter a dimension value of either 2 or 3");
                        }
                    }
                    else {
                        System.err.println("Input Mismatch: Enter an integer");
                    }
                }   

                catch (FileNotFoundException fnfe) {
                    System.err.println(fnfe.getMessage());
                }
            }
            else if (args[0].equalsIgnoreCase("-seed") || args[0].equalsIgnoreCase("-s")) {
                 try {
                    File dimension = new File(args[1]);
                    scan = new Scanner(dimension);
                    if (scan.hasNextInt()){
                        if ((Integer.parseInt(args[1]) == 2 || (Integer.parseInt(args[1]) == 3))) {
                            Randomizer random = new Randomizer(Integer.parseInt(args[1]));
                            SudokuGame gameOpt1 = new SudokuGame(stdIn, random.getKey(), random.getRevealed());
                            gameOpt1.play();
                        }
                        else {
                            System.err.println("Input Error: Enter a dimension value of either 2 or 3");
                        }
                    }
                    else {
                        System.err.println("Input Mismatch: Enter an integer");
                    }
                }

                catch (FileNotFoundException fnfe) {
                    System.err.println(fnfe.getMessage());
                }

            }
            else if (args[0].equalsIgnoreCase("-level") || args[0].equalsIgnoreCase("-l")) {
                try {
                    File dimension = new File(args[1]);
                    scan = new Scanner(dimension);
                    if (scan.hasNextInt()){
                        if ((Integer.parseInt(args[1]) >= 1) || (Integer.parseInt(args[1]) <= 30)) {
                            SudokuGame gameOpt2 = new SudokuGame(stdIn, dimension);
                            gameOpt2.play();
                        }
                        else {
                            System.err.println("Input Error: Type in a level value from 1 to 30");
                        }
                    }
                    else {
                        System.err.println("Input Mismatch: Type in an integer");
                    }
                }

                catch (FileNotFoundException fnfe) {
                    System.err.println("File Not Found Exception: the file is not found");
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
