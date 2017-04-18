import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

  public static void setup(BigInteger[][] dp) {
    for (int n = 0; n <= 24; n++) {
      for (int x = 0; x <= 150; x++) {
        dp[n][x] = new BigInteger("-1");
      }
    }
    dp[1][0] = BigInteger.ZERO;
    for (int i = 1; i <= 6; i++) {
      dp[1][i] = BigInteger.valueOf(i - 1);
    }
    for (int i = 7; i <= 150; i++) {
      dp[1][i] = BigInteger.valueOf(6);
    }
  }

  public static BigInteger throw_dice(int n, int x, BigInteger[][] dp) {
    if (!dp[n][x].equals(new BigInteger("-1"))) {
      return dp[n][x];
    } else {
      BigInteger temp = BigInteger.ZERO;
      int j = Math.min(x, 6);
      for (int i = 1; i <= j; i++) {
        temp = temp.add(throw_dice(n - 1, x - i, dp));
      }
      dp[n][x] = temp;
      return temp;
    }
  }

  public static void getProbability(int nThrows, int threshold, BigInteger[][] dp) {
    if (threshold > 6 * nThrows) {
      System.out.println(0);
      return;
    } else if (threshold <= nThrows) {
      System.out.println(1);
      return;
    }

    BigInteger n = new BigInteger(String.valueOf(nThrows));
    BigInteger x = new BigInteger(String.valueOf(threshold));
    BigInteger six = new BigInteger("6");
    BigInteger denominator = six.pow(nThrows);

    BigInteger numerator = denominator.subtract(throw_dice(nThrows, threshold, dp));
    if (!numerator.equals(BigInteger.ZERO)) {
      BigInteger gcd = numerator.gcd(denominator);
      numerator = numerator.divide(gcd);
      denominator = denominator.divide(gcd);
    }
    if (numerator.equals(BigInteger.ZERO)) {
      System.out.println(0);
    } else if (denominator.equals(new BigInteger("1"))) {
      System.out.println(1);
    } else {
      System.out.println(numerator + "/" + denominator);
    }
  }

  public static void main(String[] args) {
    BigInteger[][] dp = new BigInteger[25][151];
    setup(dp);
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      // EOF
      if (n + x == 0) break;
      getProbability(n, x, dp);
    }
  }
}