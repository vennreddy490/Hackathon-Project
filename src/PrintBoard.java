public class PrintBoard {

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
                    System.out.print (" | ")
                }
                //if the revealed value is "_"
                else if (revealed[i][j] == "_") {
                    System.out.print ("[ " + revealed[i][j] + " ]");
                }
                else {
                    System.out.print (" " + revealed[i][j] + " ");
                }
            }
        }
        //carry over the elements of the revealed array to the guessed array as initial values
        for (int i = 0; i < guessed.length; i++){
            for (int j = 0; j < guessed[i].length; j++){
                guessed[i][j] == revealed[i][j];
            }
        }
        for (int i = 0; i < dim; i++) {
                //if statement: checks if a guess was already made for a square that has an underline and then prints the char passed in for the square 
                if ((revealed[i][j] == "_") && (guessed[i][j] != "_"))
                System.out.print (" " + guessed[i][j] + " ");
                //else: basic grid square print out if no guess was made
                if ((revealed[i][j] == "_") && (guessed[i][j] == "_"))
                System.out.print (" _ ");
            }
        }
    } //printBoard
}