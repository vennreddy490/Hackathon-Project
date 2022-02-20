package random;
public class Randomizer {
    
    private int dim;
    private int dimSquared; // this number comes up often enough it's worth a variable.
    private char[][] key;
    private char[][] revealed;
    
    /**
    * Constructor. Creates a random key and revealed array when called.
    * 
    * @param dim the dimensions of the grid to be created.
    */
    public Randomizer(int dim) {
        this.dim = dim;
        dimSquared = dim * dim;
        key = new char[dimSquared][dimSquared];
        revealed = new char[dimSquared][dimSquared];

        for (int i = 0; i < dimSquared; i++) {
            for (int j = 0; j < dimSquared; j++) {
                key[i][j] = ' ';
                revealed[i][j] = '_';
            }
        }
        
        boolean boardIsCooking = true;
        while (boardIsCooking) {
            boardIsCooking = !makeRandomKey();
        }
        
        makeRandomRevealed();
    }
    
    
    /**
    * Getter method for the randomly produced key array.
    * 
    * @return the key array.
    */
    public char[][] getKey() {
        return key;
    }
    
    /**
    * Getter method for the randomly produced revealed array.
    * 
    * @return the revealed array.
    */
    public char[][] getRevealed() {
        return revealed;
    }
    
    /**
    * Simple method to print out the key. To be used for debugging with a driver.
    */
    void printKey() {
        for(char[] cRow : getKey()) {
            for (char c : cRow) {
                System.out.printf(" %c ", c);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
    * Simple method to print out the revealed array. To be used for debugging with a driver.
    */
    void printRevealed() {
        for(char[] cRow : getRevealed()) {
            for (char c : cRow) {
                System.out.printf(" %c ", c);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
    * Returns false if the character already exists in the same row, column, or box.
    * 
    * @return whether or not the placement is legal.
    */
    private boolean isLegal(int row, int column, char c) {
        
        // check row
        for (int i = 0; i < dimSquared; i++) {
            if (key[i][column] == c) {
                return false;
            }
        }
        
        // check column
        for (int j = 0; j < key[0].length; j++) {
            if (key[row][j] == c) {
                return false;
            }
        }
        
        // check box
        int boxRow = row / dim; // take advantage of truncating integers to find the top left index of the box
        int boxColumn = column / dim;
        
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                // looks scary; it's going through each index in the box.
                if (key[boxRow * dim + i][boxColumn * dim + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
    * Generates a random legal number in the given position.
    * 
    * @param row the row of the position
    * @param column the column of the position
    */
    private char generateLegalRandom(int row, int column) {        
        char randomChar;
        
        do {
            randomChar = (char) ((Math.random() * dimSquared) + 49);
        } while (!isLegal(row, column, randomChar));
        
        return randomChar;
    }
    
    boolean makeRandomKey() {
        
        for (int i = 0; i < dimSquared; i++) {
            for (int j = 0; j < dimSquared; j++) {
                if (hasLegalOption(i, j)) {
                    key[i][j] = generateLegalRandom(i, j);
                } else {
                    key = new char[dimSquared][dimSquared];
                    return false;
                }   
                
            }
        }
        
        return true;
    }
    
    private boolean hasLegalOption(int row, int column) {
        for (int i = 0; i < dimSquared; i++) {
            if (isLegal(row, column, (char) (i + 49))) {
                return true;
            }
        }
        return false;
    }   
    
    private void makeRandomRevealed() {
        int counter = 0;
        int x = 0;
        int y = 0;
        int numberToReveal = 0;

        if (dim == 2) {
            numberToReveal = 7;
        } else if (dim == 3) {
            numberToReveal = 33;
        }

        while (counter < numberToReveal) {
            x = (int) ((Math.random() * dimSquared));
            y = (int) ((Math.random() * dimSquared));
            
            if (revealed[x][y] == '_') {
                counter++;
                revealed[x][y] =  key[x][y];
            }
            
        }
        
    }
    
    
}