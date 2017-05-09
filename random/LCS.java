import java.io.*;
import java.util.*;

public class LCS {
  // http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
  public static int lcs(String X, String Y, int m, int n) {
    int[][] dp = new int[m+1][n+1];
    int i = 0, j = 0;
    for (i = 0; i <= m; i++) {
      for (j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (X.charAt(m-1) == Y.charAt(n-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        }
      }
    }
    return dp[m][n];
  }

  /*int lcs( char *X, char *Y, int m, int n ) {
    if (m == 0 || n == 0)
     return 0;
    if (X[m-1] == Y[n-1])
     return 1 + lcs(X, Y, m-1, n-1);
    else
     return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
  }*/

  public static void main(String[] args) {
    String X = "In the above partial";
    String Y = "is being partial";
    int m = X.length();
    int n = Y.length();
    System.out.println(lcs(X, Y, m, n));
  }
}