import java.util.Arrays;
import java.util.ArrayList;
public class MyProgram {
    public static int[][] board = new int[9][9];
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                board[i][j] = -1;
        }
        fillCell(0, 0);
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i > 0)
                System.out.println("---------------------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j > 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }
    public static boolean fillCell(int row, int col) {
        if (row == 9)
            return true;
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol > 8) {
            nextCol = 0;
            nextRow++;
        }
        if (board[row][col] > 0)
            return fillCell(nextRow, nextCol);
        ArrayList<Integer> options = shuffle(findOptions(row, col));
        for (int i = 0; i < options.size(); i++) {
            board[row][col] = options.get(i);
            if (fillCell(nextRow, nextCol))
                return true;
            board[row][col] = 0;
        }
        return false;
    }
    public static ArrayList<Integer> findOptions(int row, int col) { // checkRow checkCol checkBox
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++)
            arr.add(i);
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != 0) 
                arr.remove(Integer.valueOf(board[row][j]));
            if (board[j][col] != 0)
                arr.remove(Integer.valueOf(board[j][col]));
        }
        int rowBox = (row / 3) * 3;
        int colBox = (col / 3) * 3;
        for (int k = rowBox; k < rowBox + 3; k++) {
            for (int l = colBox; l < colBox + 3; l++) {
                if (board[k][l] != 0)
                    arr.remove(Integer.valueOf(board[k][l]));
            }
        }
        return arr;
    }
    public static ArrayList<Integer> shuffle(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int rand = (int)(Math.random() * arr.size());
            int temp = arr.get(rand);
            arr.remove(rand);
            arr.add(temp);
        }
        return arr;
    }
}