import java.io.*;
import java.util.*;

public class Main {

  public static int numPrimeFactors(int n) {
    int numPrimeFactors = 0;

    while (n % 2 == 0) {
      n /= 2;
      numPrimeFactors++;
    }
    // n must be odd at this point => skip even numbers
    for (int i = 3; i <= Math.sqrt(n); i+=2) {
      while (n % i == 0) {
        n /= i;
        numPrimeFactors++;
      }
    }
    // handle the case when n is a prime number greater than 2
    if (n > 2) {
      numPrimeFactors++;
    }

    return numPrimeFactors;
  }

  public static void getFactorials(int n, int[] factorials, int[] numFactors) {
    int count = 0;
    for (int i = 2; i <= n; i++) {
      if (numFactors[i] == 0) {
        numFactors[i] = numPrimeFactors(i);
      }
      count += numFactors[i];
      factorials[i] = count;
    }
    factorials[n] = count;
    return;
  }

  public static void main(String[] args) {
    // memoize the number of prime factors that can express n!
    int[] factorials = new int[1000001];
    // memoize the number of prime factors than can express n
    int[] numFactors = new int[1000001];
    // preprocess prime factorization for all numbers up to 1000000
    getFactorials(1000000, factorials, numFactors);

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      System.out.println(factorials[n]);
    }
  }
}