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

public class MainBR {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int n = Integer.parseInt(br.readLine());

    while (n != 0) {
      Pair[] blocks = new Pair[n];
      int[] lis = new int[n];
      Arrays.fill(lis, 1);

      // build an array of block pairs
      for (int i = 0; i < n; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int l = Integer.parseInt(tokens[0]);
        int r = Integer.parseInt(tokens[1]);
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
      n = Integer.parseInt(br.readLine());
    }
    System.out.println("*");
  }
}