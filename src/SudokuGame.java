import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SudokuGame {
    private int dimensions;
    private int indencies;
    private char[][] key;
    private char[][] revealed;
    private char[][] guessed;
    private Scanner input;
    private void parseSeed(File seedFile) {
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


    
}