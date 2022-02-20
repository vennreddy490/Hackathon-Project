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
    * Constructor for board generated via the randomizer (no command line arguments).
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
    
    /**
    * Prints the board.
    */
    private void printBoard () {
        int dim = (int) Math.sqrt(key.length); // dim being short for dimension
        // This section prints out the first line.
        System.out.print("   ╔");
        
        for(int i = 0; i < dim; i++) {
            System.out.print("═══");
        }
        
        for(int i = 0; i < dim - 1; i++) {
            System.out.print("╦");
            for(int j = 0; j < dim; j++) {
                System.out.print("═══");
            }
        }
        
        System.out.println("╗");
        
        // This section prints out everything other than the top and bottom lines.
        for (int m = 0; m < dim; m++) {
            
            // This prints out the numbers & the vertical dividers.
            for (int i = 0; i < dim; i++) {
                System.out.printf("%d  ║", (m * dim) + i);
                for (int j = 0; j < dim; j++) {
                    for (int k = 0; k < dim; k++) {

                        if (revealed[(m * dim) + i][(j * dim) + k] != '_') {
                            System.out.printf("[%c]", revealed[(m * dim) + i][(j * dim) + k]);
                        } else if (cheat) {
                            System.out.printf(" %c ", key[(m * dim) + i][(j * dim) + k]);
                        } else {
                            System.out.printf(" %c ", guessed[(m * dim) + i][(j * dim) + k]);
                        }
                    }
                    System.out.print("║");
                }
                System.out.println();
            }
            
            /*
            * This next section prints out the horizontal dividers.
            * We put it in an if statement because we don't want to call this the last time.
            */
            if (m != dim - 1) {
                System.out.print("   ╠");
                
                for(int i = 0; i < dim; i++) {
                    System.out.print("═══");
                }
                
                for(int i = 0; i < dim - 1; i++) {
                    System.out.print("╬");
                    for(int j = 0; j < dim; j++) {
                        System.out.print("═══");
                    }
                }
                
                System.out.println("╣");
            }
        }

        // Now we print out the bottom line of the grid!
        System.out.print("   ╚");
        
        for(int i = 0; i < dim; i++) {
            System.out.print("═══");
        }
        
        for(int i = 0; i < dim - 1; i++) {
            System.out.print("╩");
            for(int j = 0; j < dim; j++) {
                System.out.print("═══");
            }
        }
        
        System.out.println("╝");

        // ...and the numbers along the bottom.
        System.out.print("    ");

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.printf(" %d ", (i * dim) + j);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
    
    private void parseInput() {
        String userInput;
        userInput = stdIn.next();
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
            break;
        } // switch
    } // parseInput
    
    /**
    * Quits the game.
    */
    private void quit() {
        System.out.println();
        System.out.println("Quitting the game...");
        System.exit(0);
        // runs the quit command
    } // quit
    
    /**
    * Prints out the help menu.
    */
    private void help() {
        System.out.println();
        System.out.println("Commands Available...");
        System.out.println(" - Guess: guess row/col number");
        System.out.println(" -  Help: help");
        System.out.println(" -  Quit: quit");
        System.out.println(" - cheat: cheat");
    } // help
    
    /**
    * Is SUPPOSED to track the guess. But I don't think it works.
    */
    private void guess() {
        try {
            int row = stdIn.nextInt();
            int col = stdIn.nextInt();
            int boardNumber = stdIn.nextInt();
            if (revealed[row][col] != '_') {
                System.err.println();
                System.err.println("Invalid Command: Spot already revealed!");
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
    
    /**
    * Sets {@code cheat} to true, which lets the {@code printBoard} method know to
    * print out key instead of revealed.
    */
    private void cheat() {
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
    
    /**
    * Plays the game by calling other methods. To be used by a driver.
    */
    public void play() {
        while(!isWon()) {
            promptUser();
        }
    }
    
    /**
    * Prompts the user and then calls other methods to parse the input.
    */ 
    private void promptUser() {
        printBoard();
        System.out.println("User Command: ");
        parseInput();
    }
    
    /**
    * Checks the board to see if the player has won.
    * 
    * @return true if the player has won, false otherwise.
    */
    private boolean isWon() {
        for (int i = 0; i < guessed.length; i++) {
            for (int j = 0; j < guessed.length; j++) {
                if (guessed[i][j] != key[i][j]) {
                    return false;
                }
            }
        }
        System.out.println("Congratulations! You Won!!");
        System.exit(0);
        return true;
    }
    
    
    
}