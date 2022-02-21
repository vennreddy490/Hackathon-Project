# COMPILER NOTE:

To compile `SudokuGame.java` using the `javac` command, include the following flag as a command line argument: `-encoding ISO-8859-1`

# HOW TO PLAY:

```
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
```

The goal of Sudoku is to fill each row, column, and box with a different number 1 - N,
where N is the length and width of the grid. You'll need to use process of elimination
to figure out which numbers go where.

As an example, in the above grid, we can figure out that (8, 0) should be 2. We know it
can't be 1, 3, 4, 5, 6, or 7 because then the number would appear twice in the same
column. We also know it can't be 8 or 9 because then the number would twice in the same
row.

```
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
```

From there, we can continue by process of elimination. We know  (6, 0) can't be 1, 2, 4,
5, 6, 7, or 9, because those are already filled in in its column. We can also see that 
know that 8 is already present in its box (see (7, 2)), so we know that's not an option.
That means it has to be 3!

```
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
```

Continue filling in numbers like this to win the game!

# COMMANDS:

"guess <x> <y> <digit>" / "g <x> <y> <digit>"

Marks your guess at position (x, y).

"help" / "h"

Gives a helpful list of commands.

"quit" / "q"

Exits the game.

"cheat"

Does absolutely nothing.

# LEVEL SELECT:

-random <dimension> / -r <dimension>

Creates a random dimension x dimension board. Currently, the program won't allow a board
smaller than 2x2 or larger than 3x3.

# COMING SOON:

We will be soon be implementing a level system with predesigned levels in the case you don't want to
play on a randomly generated board!

It will also include the opportunity to load your own boards to test your skills
on boards you choose!

# SEED FORMATTING:

In the future, if you'd like to make your own board, you can use the following seed template:

A B
X X X X
X X X X
X X X X
X X X X
C D
C D
...

A - the dimensions of the grid (must be 2 or 3)
B - number of tiles revealed at the beginning of the game
X - the digit at eat, left to right, top to bottom
C, D - the x and y coordinates of each revealed tile

# AUTHORSHIP:

Written by Nate Kite, Venn Reddy, Daniel Grigsby, and Yushus Komarlu for 
UGAHacks7 (2022). 
