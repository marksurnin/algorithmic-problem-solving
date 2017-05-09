import java.io.*;
import java.util.*;

public class UglyNumbers {

  // public static int maxDivide(int n, int by) {
  //   while (n % by == 0) {
  //     n /= by;
  //   }
  //   return n;
  // }

  // public static boolean isUgly(int n) {
  //   n = maxDivide(n, 2);
  //   n = maxDivide(n, 3);
  //   n = maxDivide(n, 5);
  //   return (n == 1) ? true : false;
  // }

  // public static int getNthUglyNumber(int n) {
  //   int i = 1;
  //   int count = 1;

  //   while (n > count) {
  //     i++;
  //     if (isUgly(i)) {
  //       count++;
  //     }
  //   }

  //   return i;
  // }

  public static int getNthUglyNumber(int n) {
    int[] ugly = new int[n];
    int i2 = 0, i3 = 0, i5 = 0;
    int nextMultipleof2 = 2;
    int nextMultipleof3 = 3;
    int nextMultipleof5 = 5;
    int nextUglyNumber = 1;
    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      nextUglyNumber = Math.min(nextMultipleof2, Math.min(nextMultipleof3, nextMultipleof5));
      ugly[i] = nextUglyNumber;
      if (nextUglyNumber == nextMultipleof2) {
        i2++;
        nextMultipleof2 = ugly[i2]*2;
      }
      if (nextUglyNumber == nextMultipleof3) {
        i3++;
        nextMultipleof3 = ugly[i3]*3;
      }
      if (nextUglyNumber == nextMultipleof5) {
        i5++;
        nextMultipleof5 = ugly[i5]*5;
      }
    }
    return nextUglyNumber;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int number = getNthUglyNumber(sc.nextInt());
      System.out.println(number);
    }
  }
}