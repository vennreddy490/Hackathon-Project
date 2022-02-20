import random.Randomizer;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class SudokuDriver {
    public static void main(String[] args) {

        try { 
            Scanner stdIn = new Scanner(System.in);
            int gridSize = 0;
            
            System.out.println("Welcome to Sudoku!");
            System.out.println("Level Select Options:");
            System.out.println("random 2 / r 2 - random 2 x 2 grid");
            System.out.println("random 3 / r 3 - random 3 x 3 grid");
            System.out.print("Enter Level Select Option: ");
            
            String lvlInput = stdIn.nextLine();
            Scanner commandScan = new Scanner(lvlInput);
            lvlInput = lvlInput.trim();
            String parseCommand = commandScan.next();
            
            if (parseCommand.equals("r") || (parseCommand.equals("random"))) {
                if (commandScan.hasNextInt()) {
                    gridSize = commandScan.nextInt();
                    if (commandScan.hasNext()) {
                        System.err.println("Invalid Selection");
                        System.exit(0);
                    } // if
                } else {
                    System.err.println("Invalid Selection");
                    System.exit(0);
                } // if-else
                if (gridSize == 0 || gridSize < 2 || gridSize > 3) {
                    System.err.println("Invalid Selection");
                    System.exit(0);
                } // if

                Randomizer boardGen = new Randomizer(gridSize);
                SudokuGame newGame = new SudokuGame(stdIn, boardGen.getKey(), boardGen.getRevealed());
                newGame.play();
            } else {
                System.err.println("Invalid Selection.");
                System.exit(0);
            } // if-else
            commandScan.close();
        } catch (NoSuchElementException nsee) {
            System.err.println("Invalid Selection.");
            System.exit(0);
        } // try-catch

    } // main

} // SudokuDriver
