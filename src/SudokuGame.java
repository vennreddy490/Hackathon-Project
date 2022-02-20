import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SudokuGame {
    private Scanner stdIn;
    private String userInput;
    private int dimensions;
    private int indencies;
    private char[][] key;
    private char[][] revealed;
    private char[][] guessed;
    private File seedFile;
    private Scanner input;

    public SudokuGame(Scanner stdIn, char[][] key, char[][] revealed) {
        this.stdIn = stdIn;
        this.key = key;
        this.revealed = revealed;
        guessed = new char[key.length][key.length];
    }

    public SudokuGame(File seedFile) {
        this.seedFile = seedFile;
    }
    public void printBoard () {
        //prints the contents already in the revealed array
        for (int i = 0; i < revealed.length; i++) {
            for (int j = 0; j < revealed[i].length; j++) {
                //need to also figure out a way to print vertical lines after certain number of blocks based on dimensions of 2D Array
                //should go after print out number
                if((revealed.length == 9) && (i % 3 == 0)) {
                    System.out.print (" | ");
                }
                
                else if((revealed.length == 4) && (i % 2 == 0)) {
                    System.out.print (" | ");
                }
                //if the revealed value is "_"
                else if (revealed[i][j] == '_') {
                    System.out.print ("[ " + revealed[i][j] + " ]");
                }
                else {
                    System.out.print (" " + revealed[i][j] + " ");
                }
            }
        }

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                //if statement: checks if a guess was already made for a square that has an underline and then prints the char passed in for the square 
                if ((revealed[i][j] == '_') && (guessed[i][j] != '_'))
                System.out.print (" " + guessed[i][j] + " ");
                //else: basic grid square print out if no guess was made
                if ((revealed[i][j] == '_') && (guessed[i][j] == '_'))
                System.out.print (" _");
            }
        }
    } //printBoard

    public void parseInput() {
        userInput = stdIn.next();
        switch (userInput) {
            case "guess":
                // calls guess command
                break;
            case "help":
                // calls help command
                break;
            case "quit":
                // calls quit command
                break;
            case "cheat":
                // calls cheat command
                break;
            default:
                // error message for command not recognized
                // reprints board and prompts user
        } // switch

    } // parseInput

    public void quit() {
        System.out.println();
        System.out.println("Quitting the game...");
        System.exit(0);
        // runs the quit command
    } // quit

    public void help() {
        System.out.println();
        System.out.println("Commands Available...");
        System.out.println(" - Guess: guess row/col number");
        System.out.println(" -  Help: help");
        System.out.println(" -  Quit: quit");
        System.out.println(" - cheat: cheat");
    } // help

    public void guess() {
        try {
            while (stdIn.hasNext()) {
                int row = stdIn.nextInt();
                int col = stdIn.nextInt();
                int boardNumber = stdIn.nextInt();
                String value = String.valueOf(boardNumber);
                guessed[row][col] = value.charAt(0);
            }
        } catch (InputMismatchException ime) {
            System.err.println();
            System.err.println("Invalid Command: " + ime.getMessage());
            return;
        } catch (NoSuchElementException nsee) {
            System.err.println();
            System.err.println("Invalid Command: " + nsee.getMessage());
            return;
        }
    }

        public void cheat() {
            for (int i = 0; i < guessed.length; i++) {
                for (int l = 0; l < guessed.length; l++) {
                    guessed[i][l] = key[i][l];               
            }
        }
        // runs the guess command
    }
    private void parseSeed() {
        try {
        input = new Scanner(seedFile);
        dimensions = input.nextInt();
        indencies = input.nextInt();
        if (dimensions < 2 || dimensions > 3) {
            System.err.println("Dimension size is too big or too small");
            System.exit(2);
        }
        key = new char[dimensions][dimensions];
        for (int r = 0; r < dimensions; r++) {
            for (int c = 0; c < dimensions; c++) {
                String value = String.valueOf(input.nextInt());
                key[r][c] = value.charAt(0);
            }
        }
        for (int i = 0; i < indencies; i++) {
            int row = input.nextInt();
            int column = input.nextInt();
            revealed[row][column] = key[row][column];
        }
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
            System.exit(1);
        } catch (InputMismatchException ime) {
            System.err.println(ime.getMessage());
            System.exit(2);
        } catch (NoSuchElementException nsee) {
            System.err.println(nsee.getMessage());
            System.exit(2);
        }
    }

    public void play() {
        while(!isWon()) {
            promptUser();
        }
    }

    public void promptUser() {
        if (seedFile != null) {
            parseSeed();
        }
        printBoard();
        System.out.println("User Command: ");
        parseInput();
        isWon();
    }

    public boolean isWon() {
        for (int i = 0; i < guessed.length; i++) {
            for (int j = 0; j < guessed.length; j++) {
                if (guessed[i][j] != key[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    
}