import java.io.*;
import java.util.*;

public class Main {

  public static boolean isValidStartLocation(char[][] grid, int row, int col, String word) {
    // trick to explore a 2D grid
    int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    // if the first character of the word doesn't match
    // the character at the current position, return false 
    if (grid[row][col] != word.charAt(0)) {
      return false;
    }

    int curRow, curCol, k;
    int len = word.length();
    // iterate over 8 directions
    for (int dir = 0; dir < 8; dir++) {
      curRow = row + dr[dir];
      curCol = col + dc[dir];
      for (k = 1; k < len; k++) {
        if (grid[curRow][curCol] != word.charAt(k)) {
          break;
        }
        curRow += dr[dir];
        curCol += dc[dir];
      }
      if (k == len) {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int nrows = sc.nextInt();
      int ncols = sc.nextInt();

      // pad the grid boundaries with '.' for easier traversal
      char[][] grid = new char[nrows+2][ncols+2];
      for (char[] row : grid) {
        Arrays.fill(row, '.');
      }

      // read in the grid
      for (int row = 1; row <= nrows; row++) {
        String rowString = sc.next();
        for (int col = 1; col <= ncols; col++) {
          grid[row][col] = rowString.toLowerCase().charAt(col - 1);
        }
      }

      int nwords = sc.nextInt();
      for (int i = 0; i < nwords; i++) {
        String word = sc.next().toLowerCase();
        boolean found = false;
        // call isValidStartLocation on every row/col
          for (int row = 1; row <= nrows; row++) {
            for (int col = 1; col <= ncols; col++) {
              if (!found) {
                if (isValidStartLocation(grid, row, col, word)) {
                  System.out.println(row + " " + col);
                  found = true;
                }
              }
            }
          }
      }

      if (tests != 0) System.out.println();
    }
  }
}