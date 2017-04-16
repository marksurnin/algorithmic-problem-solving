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

public class Main {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int n = Integer.parseInt(br.readLine());

    while (n != 0) {
      Pair[] blocks = new Pair[n];

      // build an array of block pairs
      for (int i = 0; i < n; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int l = Integer.parseInt(tokens[0]);
        int r = Integer.parseInt(tokens[1]);
        blocks[i] = new Pair(l, r);
      }

      // using the custom comparator
      Arrays.sort(blocks);

      

      // for (Pair p : blocks) {
      //   System.out.printf("%d %d\n", p.l, p.r);
      // }
      // System.out.println();
      n = Integer.parseInt(br.readLine());
    }
  }
}