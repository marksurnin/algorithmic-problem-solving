import java.io.*;
import java.util.*;

public class Main {

  public static int floodfill(char[][] grid, int r, int c, char c1, char c2) {
    // trick to explore a 2D grid
    int[] dr = {1, 1, 0, -1, -1, -1,  0,  1};
    int[] dc = {0, 1, 1,  1,  0, -1, -1, -1};
    if (grid[r][c] != c1) return 0;
    int ans = 1;
    grid[r][c] = c2;
    for (int dir = 0; dir < 8; dir++) {
      ans += floodfill(grid, r + dr[dir], c + dc[dir], c1, c2);
    }
    return ans;
  }

  public static char[][] copyGrid(char[][] grid) {
    char[][] grid_copy = new char[grid.length][grid[0].length];
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        grid_copy[row][col] = grid[row][col];
      }
    }
    return grid_copy;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    char[][] grid;
    int length;

    try {
      int numTestCases = Integer.parseInt(br.readLine());
      line = br.readLine();
      while (line != null && line.equals("")) {
        line = br.readLine();
        // pad the grid with land
        length = line.length() + 2;
        grid = new char[101][length];
        for (char[] row : grid) {
          Arrays.fill(row, 'L');
        }

        int row = 1;
        // build the grid
        while (line.charAt(0) == 'L' || line.charAt(0) == 'W') {
          for (int i = 0; i < line.length(); i++) {
            grid[row][i+1] = line.charAt(i);
          }
          row++;
          line = br.readLine();
        }
        
        while (line != null &&!line.equals("")) {
          String[] tokens = line.trim().split("\\s+");
          int r = Integer.parseInt(tokens[0]);
          int c = Integer.parseInt(tokens[1]);
          char[][] grid_copy = copyGrid(grid);
          System.out.println(floodfill(grid_copy, r, c, 'W', '.'));
          line = br.readLine();
        }        
        if (line != null) System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}