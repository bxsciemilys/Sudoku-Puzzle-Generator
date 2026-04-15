**Program Overview**

- My program generates a randomized solved sudoku board by using recursion and methods to eliminate invalid options and fill the board.

**Data Structures**

- The board itself is a 2D array, and an ArrayList is used to eliminate invalid numbers and keep viable ones. For each square, the ArrayList initializes with numbers 1-9, and invalid options are removed with other methods. Then, one valid number is picked to be added to the board.

**Algorithm Design**

- Recursion is used to make sure that no numbers are added to the board such that the board becomes impossible to complete. The program generates a valid number and plugs it in, then moves onto the next square. If the number generated before is actually invalid or makes the board impossible and there are no valid options for the next square, the program backtracks and tries again with a different number.

**Methods**

- main:   
- fillCell: The method for the main algorithm. It runs through the board recursively, generating valid numbers with the findOptions method and shuffling them with the shuffle method to create a random board each compile. The very beginning of fillCell has an if statement to end the method once the entire board has been filled. Then, the nextRow and nextCol are calculated by adding 1 to nextCol, then compensating for overflow by adding 1 to nextRow if nextCol is greater than 8\. Then, the board checks whether the current square is filled, and recursively calls fillCell for nextRow and nextCol if so. After this, options are generated with findOptions and shuffled with shuffle. A for loop is then used to plug in all the options generated, and if one of them works such that the call to fillCell(nextRow, nextCol) is true, true is returned. Otherwise, because all options do not work, the current square is set to 0 and false is returned.  
- findOptions: This method is a combination of three things that need to be checked — the rows, the columns, and the 3x3 box. It takes the row and column as parameters, and first creates an ArrayList and fills it with the numbers 1-9 as the starting options. Then, it starts removing numbers that already exist in the same row by using a for loop that iterates through the row while keeping the column constant. The same is done for columns to remove numbers that already exist in the same column. The idea for finding the 3x3 box is by first finding the top left corner of the box it is in, then iterating through by using nested for loops. By dividing the row index by 3, you can find the row the box is in if you are considering the grid of 3x3 boxes and not the grid of 9x9. For example, rows 0, 1, and 2 are all in the first row of 3x3 boxes, which would be index 0\. Rows 3, 4, and 5 are all in the second row of 3x3 boxes, which would be index 1\. After that, you can multiply the result by 3 to get the top left corner. The same can be done with columns, to get the exact index of the top left corner of the correct box. You can then use a nested for loop, starting at the row and column indexes calculated, and ending at those indexes \+ 3, to iterate through each box and remove numbers that are already present.  
- shuffle: Shuffles the ArrayList generated in findOptions. It does so by iterating through the ArrayList using a for loop, generating a random index, setting the value of that index in the ArrayList to a temporary variable, removing that index, then adding the temporary variable back at the end of the ArrayList.

**Testing Plan**

- I first tested the program just by running it with a blank starting board a few times and checking to make sure that the boards generated were all valid. Then, I added selected valid digits to random squares in the initial board and checked to see if the program would still work and keep those digits the same while generating a valid board. Lastly, I tried adding two invalid digits to the initial board (ex. having two 1’s in the same row) and seeing if the program would ignore it and generate an incorrect board.

**Challenges and Solutions**

- Coming up with an algorithm that would consistently work was very difficult. My first attempt simply didn’t work out logically. It would generate all options and remove invalid ones, then plug in a random option, but that would not always work because the program did not have any failsafes in the case that a square was filled such that the next square would be impossible to fill. This program was based on pure chance, and with all the squares in a sudoku board, had an extremely low chance of actually working. To solve the problem of not being able to check the next square, I used a recursive method that would check valid options, then backtrack if needed.