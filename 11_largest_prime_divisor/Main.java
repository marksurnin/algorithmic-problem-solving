import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    long n = Long.parseLong(br.readLine());
    while (n != 0) {
      // important: negative integers can also be divisible by primes
      n = Math.abs(n);
      long max_divisor = 0;
      int num_divisors = 0;
      for (long p = 2; p * p <= n; p++) {
        if (n % p == 0) {
          max_divisor = Math.max(max_divisor, p);
          num_divisors++;
        }
        while (n % p == 0) {
          n /= p;
        }
      }
      if (n > 1) {
        max_divisor = Math.max(max_divisor, n);
        num_divisors++;
      }

      System.out.println(num_divisors > 1 ? max_divisor : -1);
      
      n = Long.parseLong(br.readLine());
    }
  }
}