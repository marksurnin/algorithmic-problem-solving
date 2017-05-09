import java.io.*;
import java.util.*;

public class RodCutting {
  // bottom-up dp
  // http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
  public static int cutRod(int[] price, int n) {
    int[] dp = new int[n+1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      int maxVal = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        maxVal = Math.max(maxVal, price[j] + dp[i-j-1]);
      }
      dp[i] = maxVal;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
    int n = price.length;
    System.out.println(cutRod(price, n));
  }
}