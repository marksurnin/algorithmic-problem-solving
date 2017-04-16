import java.io.*;
import java.util.*;

public class Main {

  public static ArrayList<String> permutationsStr;

  public static String swap(String str, int a, int b) {
    char temp;
    char[] arr = str.toCharArray();
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return String.valueOf(arr);
  }

  public static void getPermutations(String str, int l, int r) {
    if (l == r) {
      permutationsStr.add(str);
    } else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        getPermutations(str, l+1, r);
      }
    }
  }

  public static int[] getPermutations(int a) {
    String s = Integer.toString(a);
    permutationsStr = new ArrayList<String>();
    getPermutations(s, 0, s.length() - 1);
    permutationsStr.add(String.valueOf(a));
    int[] permutationsInt = new int[permutationsStr.size()];
    for (int i = 0; i < permutationsStr.size(); i++) {
      permutationsInt[i] = Integer.parseInt(permutationsStr.get(i));
    }
    permutationsStr.clear();
    return permutationsInt;
  }

  public static boolean isAnagrammaticPrime(int a, boolean[] primesBool) {
    int[] permutations = getPermutations(a);
    for (int i = 0; i < permutations.length; i++) {
      if (!primesBool[permutations[i]]) return false;
    }
    return true;
  }

  public static boolean[] sieveOfErathosthenes(int n) {
    // ArrayList<Integer> primesList = new ArrayList<Integer>();
    boolean[] primes = new boolean[n+1];
    Arrays.fill(primes, true);

    for (int i = 2; i*i <= n; i++) {
      if (primes[i]) {
        for (int j = i*2; j <= n; j += i) {
          primes[j] = false;
        }
      }
    }

    // for (int i = 2; i <= n; i++) {
    //   if (primes[i]) primesList.add(i);
    // }

    // int[] arr = primesList.stream().mapToInt(i -> i).toArray();
    // return arr;
    return primes;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean[] primesBool = sieveOfErathosthenes(1000);

    ArrayList<Integer> primesList = new ArrayList<Integer>();
    for (int i = 2; i <= 1000; i++) {
      if (primesBool[i]) primesList.add(i);
    }
    int[] primes = primesList.stream().mapToInt(i -> i).toArray();

    while (sc.hasNext()) {
      boolean found = false;
      int n = sc.nextInt();
      if (n == 0) break;
      int upperBound = (int) Math.pow(10, String.valueOf(n).length());
      if (upperBound > 1000) upperBound = 1000;
      int i;
      for (i = 0; i < primes.length; i++) {
        if (primes[i] > n && primes[i] < upperBound) {
          if (isAnagrammaticPrime(primes[i], primesBool)) {
            System.out.println(primes[i]);
            found = true;
            break;
          }
        }
      }
      if (!found) System.out.println(0);
    }
  }
}