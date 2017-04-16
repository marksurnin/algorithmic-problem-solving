import java.io.*;
import java.util.*;

public class Main {

  public static int[][] board;
  public static int[][] prev;
  public static int[][] changes;
  public static int rows;
  public static int cols;  

  public static int computeStatus(int row, int col) {
    int[] neighbors = new int[4];
    neighbors[0] = prev[row-1][col] == -1 ? -1 : prev[row-1][col];
    neighbors[1] = prev[row+1][col] == -1 ? -1 : prev[row+1][col];
    neighbors[2] = prev[row][col-1] == -1 ? -1 : prev[row][col-1];
    neighbors[3] = prev[row][col+1] == -1 ? -1 : prev[row][col+1];

    int stable = 0;
    int active = 0;
    int unstable = 0;
    for (int neighbor : neighbors) {
      if (neighbor == 2) {
        stable++;
        active++;
      }
      if (neighbor == 3) {
        active++;
      }
    }

    if (stable > 1) {
      return 2;
    } else {
      if (active > 0) {
        return 3;
      }
    }
    return 1;
  }

  public static void copyBoard(int[][] original, int[][] target) {
    for (int row = 0; row < rows + 2; row++) {
      for (int col = 0; col < cols + 2; col++) {
        target[row][col] = original[row][col];
      }
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();
      String[] tokens = line.trim().split("\\s+");
      rows = Integer.parseInt(tokens[0]);
      cols = Integer.parseInt(tokens[1]);
      int k = Integer.parseInt(tokens[2]);
      // necessary for proper parsing of the board
      tokens = new String[cols];
      // padding the boards with `-1`
      board = new int[rows+2][cols+2];
      prev = new int[rows+2][cols+2];
      changes = new int[rows][cols];

      for (int i = 0; i < rows + 2; i++) {
        if (i != 0 && i != rows + 1) {
          line = br.readLine();
          tokens = line.trim().split("\\s+");
        }
        
        for (int j = 0; j < tokens.length + 2; j++) {
          if (i == 0 || i == rows + 1) {
            board[i][j] = -1;
          } else {
            if (j == 0 || j == tokens.length + 1) {
              board[i][j] = -1;
            } else {
              board[i][j] = Integer.parseInt(tokens[j-1]);
            }
          }  
        }
      }

      copyBoard(board, prev);

      for (int i = 0; i < k; i++) {
        for (int row = 1; row < rows + 1; row++) {
          for (int col = 1; col < cols + 1; col++) {
            int newStatus = computeStatus(row, col);
            if (prev[row][col] != newStatus) {
              board[row][col] = newStatus;
              changes[row-1][col-1]++;
            }
          }
        }
        copyBoard(board, prev);
      }

      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          System.out.printf("%d", changes[row][col]);
          if (col < cols - 1) System.out.printf(" ");
        }
        System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}