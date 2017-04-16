import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
  public int l;
  public int r;

  Pair(int l, int r) {
    this.l = l;
    this.r = r;
  }

  @Override
  public int compareTo(Pair pair) {
    if (this.l > pair.l) {
      return 1;
    } else if (this.l < pair.l) {
      return -1;
    } else {
      if (this.r > pair.r) {
        return 1;
      } else {
        return -1;
      }
    }
  }
}

public class MainSC {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while (n != 0) {
      Pair[] blocks = new Pair[n];
      int[] lis = new int[n];
      Arrays.fill(lis, 1);

      // build an array of block pairs
      for (int i = 0; i < n; i++) {
        int l = sc.nextInt();
        int r = sc.nextInt();
        blocks[i] = new Pair(l, r);
      }

      // sort using the custom comparator
      Arrays.sort(blocks);

      int max = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (blocks[j].l >= blocks[i].l && blocks[j].r >= blocks[i].r) {
            lis[j] = Math.max(lis[j], lis[i] + 1);
          }
          max = Math.max(max, lis[j]);
        }
      }
      System.out.println(max);
      n = sc.nextInt();
    }
    System.out.println("*");
  }
}