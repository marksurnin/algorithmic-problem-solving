import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        int bsize = Integer.parseInt(br.readLine());
        int nblocks = Integer.parseInt(br.readLine());
        int[][] board = new int[101][101];

        // build the board
        for (int j = 0; j < nblocks; j++) {
          String[] tokens = br.readLine().trim().split("\\s+");
          int r1 = Integer.parseInt(tokens[0]);
          int c1 = Integer.parseInt(tokens[1]);
          int r2 = Integer.parseInt(tokens[2]);
          int c2 = Integer.parseInt(tokens[3]);
          for (int a = r1; a <= r2; a++) {
            for (int b = c1; b <= c2; b++) {
              board[a][b] = 1;
            }
          }
        }

        // Max 2D range sum
        int ans = 0, tmp = 0, length = 0, width = 0;
        for (int a = 1; a <= bsize; a++) {
          int[] sum = new int[101];
          for (int b = a; b <= bsize; b++) {
            for (int k = 1; k <= bsize; k++) {
              if (board[b][k] == 0) {
                //
                sum[k]++;
              }
              // sum[k] += (!board[b][k] ? 1 : 0);
              if (k == 1 || tmp != length * width) {
                tmp = 0;
                length = 0;
              }
              tmp += sum[k];
              length++;
              width = b - a + 1;
              if (tmp == length * width) {
                if (tmp > ans) ans = tmp;
              }
            }
          }
        }
        System.out.println(ans);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}