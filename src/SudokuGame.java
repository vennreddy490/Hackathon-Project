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
    private boolean cheat = false;
    
    /**
     * Constructor for no command line arguments (board generated via the randomizer).
     * 
     * @param stdIn the Scanner for standard input
     * @param key randomly generated key
     * @param revealed the randomly generated starting hints
     */
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

    /**
     * Constructor for command line arguments (inputting a seed file).
     * 
     * @param stdIn the Scanner for standard input
     * @param seedFile the seed file.
     */
    public SudokuGame(Scanner stdIn, File seedFile) {
        parseSeed(seedFile);
        this.stdIn = stdIn;
    }

    public void printBoard () {
        
        for(int i = 0; i < guessed.length; i++) {
            for(int j = 0; j < guessed.length; j++) {
                if (cheat == false) {
                    System.out.printf(" %c ", guessed[i][j]);
                } else {
                    System.out.printf(" %c ", key[i][j]);
                }
            }
            System.out.println();
        }
        cheat = false;
    }
    
    public void parseInput() {
        
        String userInput;
        
        userInput = stdIn.next();
        System.out.println(userInput);
        switch (userInput) {

            case "guess":
            guess();
            break;

            case "g":
            guess();
            break;

            case "help":
            help();
            break;

            case "h":
            help();
            break;

            case "quit":
            quit();
            break;

            case "q":
            quit();
            break;

            case "cheat":
            cheat();
            break;

            default:
            System.err.println();
            System.err.println("Error: Command not recognized.");
            return;
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
            int row = stdIn.nextInt();
            int col = stdIn.nextInt();
            int boardNumber = stdIn.nextInt();
            if (revealed[row][col] != 0) {
                return;
            }
            String value = String.valueOf(boardNumber);
            guessed[row][col] = value.charAt(0);
        } catch (InputMismatchException ime) {
            System.err.println();
            System.err.println("Invalid Command: " + ime.getMessage());
            return;
        } catch (NoSuchElementException nsee) {
            System.err.println();
            System.err.println("Invalid Command: " + nsee.getMessage());
            return;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println();
            System.err.println("Invalid Command " + aioobe.getMessage());
            return;
        } catch (NullPointerException npe) {
            System.err.println();
            System.err.println("Invalid Command " + npe.getMessage());
            return;
        }
    }
    
    public void cheat() {
        cheat = true;
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