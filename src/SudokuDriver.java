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
            game = new SudokuGame(stdIn, seedFile);
            game.play();

        } else {

            System.err.println();
            System.err.println("Error: Provide path to seed file, or leave blank to generate a random board.");

        } // if-else

    } // main

} // SudokuDriver
