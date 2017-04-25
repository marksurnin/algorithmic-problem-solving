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
      // System.out.println(i);
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

      // reverse = new StringBuilder(line).reverse().toString();
      // System.out.println(line);
      // System.out.println(reverse);
      // int i, j = 0;
      // int len = line.length();
      // int maxJ = 0;
      // boolean found = true;
      // for (i = 0; i < len; i++) {
      //   found = true;
      //   // if (line.charAt(i) == reverse.charAt(0)) {
      //   for (j = 0; j < len && found; j++) {
      //     // if (i+j >= len && found) {
      //     //   continue;
      //     // } else if (line.charAt(i+j) != reverse.charAt(j)) {
      //     //   found = false;
      //     //   // System.out.println(i + " " + j);
      //     //   maxJ = Math.max(maxJ, j);
      //     // }

      //     if (i+j >= len || line.charAt(i+j) != reverse.charAt(j)) {
      //       found = false;
      //       // System.out.println(i + " " + j);
      //       maxJ = Math.max(maxJ, j);
      //     }
      //     System.out.println(j);
      //   }
      //   // }
      // }
      // System.out.println(i + " " + j + " " + len);
      // if (j == len - 2) {
      //   System.out.println(line);
      //   // System.out.println("чикипуки");
      // } else {
      //   // System.out.println(maxJ);
      //   // System.out.println(reverse.substring(maxJ));
      //   StringBuilder sb = new StringBuilder(line);
      //   sb = sb.append(reverse.substring(maxJ));
      //   System.out.println(sb);
      // }
      
      // System.out.println();
      line = br.readLine();
    }
  }
}