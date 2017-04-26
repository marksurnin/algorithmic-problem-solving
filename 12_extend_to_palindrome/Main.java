import java.io.*;
import java.util.*;

public class Main {

  static String P, T;
  static int m, n;
  static int[] b;

  static void kmpPreprocess() {
    int i = 0, j = -1;
    b[0] = -1;
    while (i < m) {
      while (j >= 0 && P.charAt(i) != P.charAt(j)) {
        j = b[j];
      }
      ++i;
      ++j;
      b[i] = j;
      // for (int x : b) {
      //   System.out.print(x + " ");
      // }
      // System.out.println();
    }

  }

  static int kmpSearch() {
    int i = 0, j = 0;
    while (i < n) {
      while (j >= 0 && T.charAt(i) != P.charAt(j)) {
        j = b[j];
      }
      i++;
      j++;
    }
    return j;
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line, reverse;

    line = br.readLine();
    while (line != null && !line.equals("")) {
      T = line;
      P = new StringBuilder(line).reverse().toString();
      m = P.length();
      n = P.length();
      b = new int[m+1];
      kmpPreprocess();
      int index = kmpSearch();
      System.out.println(T + P.substring(index));
      line = br.readLine();
    }
  }
}