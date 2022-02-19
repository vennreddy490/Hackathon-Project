import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ParseCommand {
    private Scanner stdIn;
    private String input;
    private char[][] revealed;
    private char[][] guessed;
    private char[][] key;
    char[][] testRevealed = {
        {'_', '_', '_', '2', '6', '_', '7', '_', '_'},
        {'6', '8', '_', '_', '7', '_', '_', '9', '_'},
        {'1', '9', '_', '_', '_', '4', '5', '_', '_'},
        {'8', '2', '_', '1', '_', '_', '_', '4', '_'},
        {'_', '_', '4', '6', '_', '2', '9', '_', '_'},
        {'_', '5', '_', '_', '_', '3', '_', '2', '8'},
        {'_', '_', '9', '3', '_', '_', '_', '7', '4'},
        {'_', '4', '_', '_', '5', '_', '_', '3', '6'},
        {'7', '_', '3', '_', '1', '8', '_', '_', '_'}
    };

    char[][] testKey = {
        {'4', '3', '5', '2', '6', '9', '7', '8', '1'},
        {'6', '8', '2', '5', '7', '1', '4', '9', '3'},
        {'1', '9', '7', '8', '3', '4', '5', '6', '2'},
        {'8', '2', '6', '1', '9', '5', '3', '4', '7'},
        {'3', '7', '4', '6', '8', '2', '9', '1', '5'},
        {'9', '5', '1', '7', '4', '3', '6', '2', '8'},
        {'5', '1', '9', '3', '2', '6', '8', '7', '4'},
        {'2', '4', '8', '9', '5', '7', '1', '3', '6'},
        {'7', '6', '3', '4', '1', '8', '2', '5', '9'}
    };

    public void parseInput() {
        input = stdIn.next();
        switch (input) {
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
                    guessed[i][l] = key[i][l];               }
            }
        }
        // runs the guess command
    } // guess



}
