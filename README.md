# Sudoku-Puzzle-Generator
**APCSA Sudoku Puzzle Generator** by Emily Su

**Description**: A program that generates a randomized sudoku board using recursion and backtracking.

**How to run**: Download the program, then run it in a Java compiler.

**Algorithm Design Summary**: Recursion is used to make sure that no numbers are added to the board such that the board becomes impossible to complete. The program generates a valid number and plugs it in, then moves onto the next square. If the number generated before is actually invalid or makes the board impossible and there are no valid options for the next square, the program backtracks and tries again with a different number.

**List of files**: MyProgram.java
