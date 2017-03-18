import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int coin = 1;

    int[] coins = {1, 5, 10, 25, 50};

    long[] change = new long[30001];
    change[0] = 1;
    for (int c = 0; c < coins.length; c++) {
      coin = coins[c];
      for (int i = coin; i <=30000; i++) {
        change[i] += change[i - coin];
      }
    }
    
    line = br.readLine();
    while (line != null && line.length() != 0) {
      int n = Integer.parseInt(line);
      if (change[n] == 1) {
        System.out.printf("There is only %d way to produce %d cents change.\n", change[n], n);
      } else {
        System.out.printf("There are %d ways to produce %d cents change.\n", change[n], n);
      }
      
      // for (int i = 1; i <= coins.length; i++) {
      //   if (n - coins[i] >= 0) {
      //     reachable[0][n - coins[i]] = true;
      //   }
      // }

      // for (int i = 1; i <=n; i++) {
      //   for (int money = 0; money <= n; money++) {
      //     if (reachable[i-1][money]) {
      //       for (int i = 1; i <= coins.length; i++) {
      //         if (money - coins[i] >= 0) {
      //           reachable[i][money - coins[i]] = true;
      //         }

      //       }
      //     }
      //   }
      // }

      line = br.readLine();
    }
  }
}