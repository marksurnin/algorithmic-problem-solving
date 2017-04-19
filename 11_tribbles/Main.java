import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numTestCases = sc.nextInt();
    int caseN = 1;
    while (caseN <= numTestCases) {
      int nProbabilities = sc.nextInt();
      int nTribbles = sc.nextInt();
      int nGenerations = sc.nextInt();
      double[] p = new double[1005];
      double[] dp = new double[1005];
      for (int prob = 0; prob < nProbabilities; prob++) {
        p[prob] = sc.nextDouble();
      }
      dp[0] = 0;
      for (int gen = 1; gen <= nGenerations; gen++) {
        dp[gen] = 0;
        for (int prob = 0; prob < nProbabilities; prob++) {
          dp[gen] += p[prob] * Math.pow(dp[gen-1], prob);
        }
      }
      System.out.printf("Case #%d: %.7f\n", caseN++, Math.pow(dp[nGenerations], nTribbles));
    }
  }
}