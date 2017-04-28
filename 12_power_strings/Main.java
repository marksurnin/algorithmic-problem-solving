import java.io.*;
import java.util.*;

public class Main {

  static String pattern, text;
  static int m, n;
  static int[] b;

  static void kmppatternreprocess() {
    int i = 1, j = 0;
    b[0] = 0;
    b[1] = 0;
    while (i < m) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        b[++i] = ++j;
      } else if (j == 0) {
        b[++i] = 0;
      } else {
        j = b[j];
      }
    }
  }

  static int kmpSearch() {
    int i = 1, j = 0;
    while (i-j <= n-m) {
      while (j < m ) {
        if (text.charAt(i) == pattern.charAt(j)) {
          i++;
          j++;
        } else break;
      }
      if (j == m) return i-m;
      else if (j == 0) i++;
      j = b[j];
    }
    return j;
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line, reverse;

    line = br.readLine();
    while (!line.equals(".")) {
      pattern = line;
      text = pattern + pattern;
      m = pattern.length();
      n = text.length();
      b = new int[m+1];
      kmppatternreprocess();
      int index = kmpSearch();
      System.out.println(m / index);
      line = br.readLine();
    }
  }
}