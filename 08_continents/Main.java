import java.io.*;
import java.util.*;

public class Main {

  public static int floodfill(char[][] grid, int r, int c, char c1, char c2) {
    // System.out.println(0);
    // trick to explore a 2D grid
    int[] dr = {1, 0, -1,  0};
    int[] dc = {0, 1,  0, -1};
    if (grid[r][c] != c1) return 0;
    int ans = 1;
    grid[r][c] = c2;
    for (int dir = 0; dir < 4; dir++) {
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
      line = br.readLine();
      while (line != null && !line.equals("")) {
        String[] tokens = line.trim().split("\\s+");
        int nr = Integer.parseInt(tokens[0]);
        int nc = Integer.parseInt(tokens[1]);
        line = br.readLine();
        // pad the grid with land
        grid = new char[nr+2][nc+2];
        for (char[] row : grid) {
          Arrays.fill(row, '%');
        }
        char landChar = ' ';
        char waterChar = ' ';


        int row = 1;
        // build the grid
        while (line.charAt(0) != '0' && line.charAt(0) != '1' && line.charAt(0) != '2' && line.charAt(0) != '3' && line.charAt(0) != '4' && line.charAt(0) != '5' && line.charAt(0) != '6' && line.charAt(0) != '7' && line.charAt(0) != '8' && line.charAt(0) != '9') {
          for (int i = 0; i < line.length(); i++) {
            grid[row][i+1] = line.charAt(i);
            if (landChar == ' ') {
              landChar = line.charAt(i);
            } else if (waterChar == ' ' && line.charAt(i) != landChar) {
              waterChar = line.charAt(i);
            }
          }
          row++;
          line = br.readLine();
        }
        // System.out.println(length);
        // while (line != null &&!line.equals("")) {
        tokens = line.trim().split("\\s+");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);
        if (nr == 1 && nc == 1 && r == 0 && c == 0) {
          System.out.println(0);
        } else {
          if (grid[r+1][c+1] == waterChar) {
            char temp = landChar;
            landChar = waterChar;
            waterChar = temp;
          }

          String chars = "abc";
          char third = ' ';
          for (int ch = 0; ch < 3; ch++) {
            if (chars.charAt(ch) != landChar && chars.charAt(ch) != waterChar) {
              third = chars.charAt(ch);
            }
          }
          // char[][] grid_copy = copyGrid(grid);
          // System.out.println(third);
          // System.out.println(waterChar);
          // System.out.println(grid[r+1][c+1]);
          floodfill(grid, r+1, c+1, landChar, third);
          

          ArrayList<Integer> results = new ArrayList<Integer>();
          int ans = 0;
          for (int ro = 0; ro < nr + 2; ro++) {
            for (int co = 0; co < nc + 2; co++) {
              if (grid[ro][co] == landChar) {
                // System.out.printf("%d %d\n", ro, co);
                ans = Math.max(ans, floodfill(grid, ro, co, landChar, third));
              }
            }
          }
          System.out.println(ans);
        }
        br.readLine();
        line = br.readLine();
        
        // if (line != null) System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}