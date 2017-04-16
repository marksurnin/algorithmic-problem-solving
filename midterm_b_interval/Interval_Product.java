import java.io.*;
import java.util.*;

//Assumes indices are 1-based
class Fenwick {
  public int[] table;

  public Fenwick(int maxN) {
    this.table = new int[maxN + 1];
  }

  public int sumQuery(int a, int b) {
    return sumQuery(b) - sumQuery(a - 1);
  }

  public int sumQuery(int k) {
    int ret = 0;
    while (k > 0) {
      ret += table[k];
      k &= k - 1;
    }
    return ret;
  }

  public void adjust(int i, int adj) {
    // System.out.printf("%d %d\n", i, adj);
    while (i < table.length) {
      table[i] += adj;
      i += (i & (-i));
    }
  }

  public int getValue(int i) {
    return sumQuery(i, i);
  }

  // Assumes entries of list are non-negative (i.e., cumulative sums are
  // increasing)
  // Returns first index whose cumulative sum is >= k
  // Returns -1 if all are less
  public int findFirst(int k) {
    int L = 1, R = table.length - 1;
    while (R - L > 1) {
      int M = (R + L) / 2;
      int val = sumQuery(M);
      if (val < k)
        L = M + 1;
      else
        R = M;
    }
    int LVal = sumQuery(L);
    if (LVal >= k)
      return L;
    return R == L || sumQuery(R) < k ? -1 : R;
  }
}

public class Interval_Product {

  public static int getZeroes(int i) {
    int zeroes = 0;
    while (i > 0 && (i&1) == 0) {
      // System.out.printf("%d %d\n", i, zeroes);
      i = i >> 1;
      zeroes++;
    }
    return zeroes;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);

        Fenwick ft = new Fenwick(n);

        tokens = br.readLine().trim().split("\\s+");

        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int j = 0; j < n; j++) {
          int number = Integer.parseInt(tokens[j]);
          int numZeroes = getZeroes(number);
          if (numZeroes != 0) ft.adjust(j+1, numZeroes);
        }

        while (q-- > 0) {
          tokens = br.readLine().trim().split("\\s+");
          String command = tokens[0];
          int a = Integer.parseInt(tokens[1]);
          int b = Integer.parseInt(tokens[2]);
          if (command.equals("s")) {
            int newZeroes = getZeroes(b);
            int curZeroes = ft.sumQuery(a, a);
            ft.adjust(a, newZeroes - curZeroes);
          }
          if (command.equals("q")) System.out.println(ft.sumQuery(a, b));
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}