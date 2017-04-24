import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int nrows = sc.nextInt();
      int ncols = sc.nextInt();
      // number of rows above the bad piece
      int r = sc.nextInt();
      // number of columns to the left of the bad piece
      int c = sc.nextInt();
      int nim = r ^ c;
      // number of rows below the bad piece
      nim ^= nrows - r - 1;
      // number of columns to the right of the bad piece
      nim ^= ncols - c - 1;
      if (nim == 0) {
        System.out.println("Hansel");
      } else {
        System.out.println("Gretel");
      }
    }
  }
}