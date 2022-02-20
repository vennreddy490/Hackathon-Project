A version of Sudoku, to be played in the terminal. Written by Nate Kite, Venn Reddy,
Daniel Grigsby, and Yushus Komarlu.

# HOW TO PLAY:

   ╔═════════╦═════════╦═════════╗
0  ║[6] _ [3]║[8][5] _ ║ _  _  _ ║
1  ║[7] _  _ ║ _ [1][6]║[8][2][3]║
2  ║ _  _  _ ║[3] _  _ ║[1] _  _ ║
   ╠═════════╬═════════╬═════════╣
3  ║[5] _  _ ║ _  _  _ ║ _  _  _ ║
4  ║[4] _  _ ║[7][8][5]║[3][9] _ ║
5  ║[1] _  _ ║ _ [6] _ ║[5] _  _ ║
   ╠═════════╬═════════╬═════════╣
6  ║ _ [7] _ ║ _  _ [9]║ _  _  _ ║
7  ║[9] _ [8]║[1] _  _ ║ _  _ [6]║
8  ║ _  _ [6]║ _ [3][8]║[7] _ [9]║
   ╚═════════╩═════════╩═════════╝
     0  1  2   3  4  5   6  7  8

The goal of Sudoku is to fill each row, column, and box with a different number 1 - N,
where N is the length and width of the grid. You'll need to use process of elimination
to figure out which numbers go where.

As an example, in the above grid, we can figure out that (8, 0) should be 2. We know it
can't be 1, 3, 4, 5, 6, or 7 because then the number would appear twice in the same
column. We also know it can't be 8 or 9 because then the number would twice in the same
row.

   ╔═════════╦═════════╦═════════╗
0  ║[6] _ [3]║[8][5] _ ║ _  _  _ ║
1  ║[7] _  _ ║ _ [1][6]║[8][2][3]║
2  ║ _  _  _ ║[3] _  _ ║[1] _  _ ║
   ╠═════════╬═════════╬═════════╣
3  ║[5] _  _ ║ _  _  _ ║ _  _  _ ║
4  ║[4] _  _ ║[7][8][5]║[3][9] _ ║
5  ║[1] _  _ ║ _ [6] _ ║[5] _  _ ║
   ╠═════════╬═════════╬═════════╣
6  ║ _ [7] _ ║ _  _ [9]║ _  _  _ ║
7  ║[9] _ [8]║[1] _  _ ║ _  _ [6]║
8  ║ 2  _ [6]║ _ [3][8]║[7] _ [9]║
   ╚═════════╩═════════╩═════════╝
     0  1  2   3  4  5   6  7  8

From there, we can continue by process of elimination. We know  (6, 0) can't be 1, 2, 4,
5, 6, 7, or 9, because those are already filled in in its column. We can also see that 
know that 8 is already present in its box (see (7, 2)), so we know that's not an option.
That means it has to be 3!

   ╔═════════╦═════════╦═════════╗
0  ║[6] _ [3]║[8][5] _ ║ _  _  _ ║
1  ║[7] _  _ ║ _ [1][6]║[8][2][3]║
2  ║ _  _  _ ║[3] _  _ ║[1] _  _ ║
   ╠═════════╬═════════╬═════════╣
3  ║[5] _  _ ║ _  _  _ ║ _  _  _ ║
4  ║[4] _  _ ║[7][8][5]║[3][9] _ ║
5  ║[1] _  _ ║ _ [6] _ ║[5] _  _ ║
   ╠═════════╬═════════╬═════════╣
6  ║ 3 [7] _ ║ _  _ [9]║ _  _  _ ║
7  ║[9] _ [8]║[1] _  _ ║ _  _ [6]║
8  ║ 2  _ [6]║ _ [3][8]║[7] _ [9]║
   ╚═════════╩═════════╩═════════╝
     0  1  2   3  4  5   6  7  8

Continue filling in numbers like this to win the game!

# COMMANDS

"guess <x> <y> <digit> / g <x> <y> <digit>"

Marks your guess at position (x, y).

"help"

Gives a helpful list of commands.

"quit"

exits the game

# LEVEL SELECT

Without command line arguments, the game generates a random 3x3 grid (a 3x3 grid contains 
digits 1-9). But with command line arguments, you can play on different boards.

-random <dimension> / -r <dimension>

Creates a random dimension x dimension board. Currently, the program won't allow a board smaller
than 2x2 or larger than 3x3.

-level <level number> / -l <level number>

Loads one of our 30 hand-picked levels. Higher numbers are more difficult.

-seed <path> / -s <path>

Allows you to load a board from a custom seed!

# SEED FORMAT

If you'd like to make your own board, you can use the following seed template:

A B
X X X X
X X X X
X X X X
X X X X
I J
I J
I J
...

A - the dimensions of the grid (must be 2 or 3)
B - number of revealed tiles
X - the number of each index, left to right, top to bottom
I, J - the x and y coordianates of each revealed tile