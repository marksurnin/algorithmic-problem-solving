import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

  public static int lcm(int a, int b) {
    // BigInteger A = new BigInteger(String.valueOf(a));
    // BigInteger B = new BigInteger(String.valueOf(b));
    // BigInteger gcd_AB = A.gcd(B);
      // int gcd = 1;
      // int temp = gcd(a, b);
      // if (temp > 0) {
      //   gcd = temp;
      // }
    return a * (b / gcd(a, b));
  }

  public static int gcd(int a, int b) {
    // if (a < b) {
    //   int temp = a;
    //   a = b;
    //   b = temp;
    // }
    // if (b == 0) return a;
    // else return gcd(b, a%b);

    if (b == 0) return a;
    else return gcd(b, a%b);
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    while (true) {
    // Scanner sc = new Scanner(System.in);
    // while (sc.hasNext()) {
      int n = Integer.parseInt(br.readLine());
      // BigInteger z = BigInteger.ZERO;
      // BigInteger N = sc.nextBigInteger();
      if (n == 0) break;

      ArrayList<Integer> divisors = new ArrayList<Integer>();
      
      for (int i = 1; i <= n/i; i++) {
        if ((n % i) == 0) {
          int div = n / i;
          divisors.add(i);
          if (i != div) {
            divisors.add(div);
          }
        }
      }
      int ans = 0;
      for (int i = 0; i < divisors.size(); i++) {
        for (int j = i; j < divisors.size(); j++) {
          if (lcm(divisors.get(j), divisors.get(i)) == n) {
            ans++;
          }
        }
      }
      System.out.println(n + " " + ans);
    }
  }
}