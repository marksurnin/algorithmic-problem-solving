import java.io.*;
import java.util.*;

public class Main_alt {

  public static int[] buildKMPTable(String pattern) {
    int[] table = new int[pattern.length() + 1];
    for (int i = 2; i < table.length; i++) {
      int j = table[i-1];
      while (true) {
        if (pattern.charAt(j) == pattern.charAt(i-1)) {
          table[i] = j+1;
          break;
        } else if (j == 0) {
          break;
        } else {
          j = table[j];
        }
      }
    }
    return table;
  }

  public static int simulate(int[] table, String text, String pattern) {
    int index = 0;
    for (int i = 0; i < text.length(); i++) {
      while (true) {
        if (text.charAt(i) == pattern.charAt(index)) {
          index++;
          break;
        } else if (index == 0) {
          break;
        }
        index = table[index];
      }
      if (index == table.length - 1) break;
    }
    return index;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String text = sc.next();
      String pattern = new StringBuilder(text).reverse().toString();
      int[] table = buildKMPTable(pattern);
      int index = simulate(table, text, pattern);
      System.out.println(text + pattern.substring(index));
    }
  }
}