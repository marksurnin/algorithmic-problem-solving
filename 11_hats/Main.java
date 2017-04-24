import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // build factorial array up to 12!
    double[] denominator = new double[13];
    denominator[0] = 1;
    for (int i = 1; i <= 12; i++) {
      denominator[i] = i * denominator[i - 1];
    }

    // Bowen's third idea with circles
    double[] dp = new double[13];
    dp[2] = 1;
    for (int i = 3; i <= 12; i++) {
      dp[i] = (i - 1) * (dp[i-1] + dp[i-2]);
    }

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      System.out.println((int) dp[num] + "/" + (int) denominator[num]);
    }
  }
}