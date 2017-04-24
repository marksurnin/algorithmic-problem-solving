import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    double[][] dp = new double[501][501];
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      // EOF
      if (n == 0) break;
      double p = sc.nextDouble();

      for (int i = 0; i <= n; i++) {
        dp[0][i] = 1;
      }

      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
          dp[i][j] = dp[i-1][j];
          if (i == j + 1) {
            dp[i][j] -= Math.pow(p, j+1);
          } else if (i > j + 1) {
            dp[i][j] -= dp[i - j - 2][j] * Math.pow(p, j + 1) * (1-p);
          }
        }
      }
      double ans = 0;
      for (int i = 1; i <= n; i++) {
        ans += i * (dp[n][i] - dp[n][i-1]);
      }
      System.out.printf("%.6f\n", ans);
    }

  }
}