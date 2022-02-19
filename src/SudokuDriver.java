public class SudokuDriver {
    
    public static void main(String[] args) {

        if (args.length == 0) {

            Randomizer boardGen = new Randomizer(3);

        } else if (args.length == 1) {

            //  Uses the seed file

        } else {

            // Returns a usage error because they had more than one command line argument

        } // if-else

    } // main

} // SudokuDriver
