import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SudokuGame {
    private Scanner stdIn;
    private char[][] key;
    private char[][] revealed;
    private char[][] guessed;
    
    public SudokuGame(Scanner stdIn, char[][] key, char[][] revealed) {
        this.stdIn = stdIn;
        this.key = key;
        this.revealed = revealed;
        guessed = new char[key.length][key.length];
        
        for(int i = 0; i < guessed.length; i++) {
            for(int j = 0; j < guessed.length; j++) {
                guessed[i][j] = revealed[i][j];
            }
            System.out.println();
        }
    }
    
    public SudokuGame(Scanner stdIn, File seedFile) {
        parseSeed(seedFile);
        this.stdIn = stdIn;
    }
    public void printBoard () {
        
        for(int i = 0; i < guessed.length; i++) {
            for(int j = 0; j < guessed.length; j++) {
                System.out.printf(" %c ", guessed[i][j]);
            }
            System.out.println();
        }
        
    }
    
    public void parseInput() {
        
        String userInput;
        
        userInput = stdIn.next();
        switch (userInput) {
            case "guess":
            // calls guess command=
            guess();
            break;
            case "help":
            // calls help command
            help();
            break;
            case "quit":
            quit();
            // calls quit command
            break;
            case "cheat":
            cheat();
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

    private void parseSeed(File seedFile) {
        
        Scanner input;
        int dimensions;
        int indencies;
        
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