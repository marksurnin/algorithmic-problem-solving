import java.io.*;
import java.util.*;

public class Main {
  public static HashMap<String, Integer> mapNames;
  static int numNames;

  private static class UnionFind {
    int[] parents, ranks;
    int n;

    public UnionFind(int n) {
      this.n = n;
      // given integers A and B are 1 <= A <= N, 1 <= A <= N, thus using 1-based indexing
      parents = new int[n];
      ranks = new int[n];
      // each node is initially a parent of itself and its rank is 1
      for (int i = 0; i < n; i++) {
        parents[i] = i;
        ranks[i] = 1;
      }
    }

    int union(int x, int y) {
      int xRoot = find(x);
      int yRoot = find(y);

      // same set, no need to unite anything
      if (xRoot == yRoot) {
        return ranks[xRoot];
      }
      int currentSize = -1;
      // move trees around to minimize depth of final tree
      if (ranks[xRoot] > ranks[yRoot]) {
        parents[yRoot] = xRoot;
        ranks[xRoot] += ranks[yRoot];
        currentSize = ranks[xRoot];
      } else {
        parents[xRoot] = yRoot;
        ranks[yRoot] += ranks[xRoot];
        currentSize = ranks[yRoot];
      }
      return currentSize;
    }

    // find the root of a tree, which a given element belongs to
    int find(int x) {
      if (parents[x] != x) {
        parents[x] = find(parents[x]);
      }
      return parents[x];
    }

    // helpful for debugging
    void printContents() {
      System.out.print("Parents: ");
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", parents[i]);
      }
      System.out.println();

      System.out.print("Ranks:   ");
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", ranks[i]);
      }
      System.out.println("\n");
    }
  }

  public static int pos(String x) {
    if (mapNames.containsKey(x)) {
      return mapNames.get(x);
    } else {
      mapNames.put(x, numNames++);
      return numNames - 1;
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String[] line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        int numFriendships = Integer.parseInt(br.readLine());
        UnionFind uf = new UnionFind(numFriendships * 2);
        mapNames = new HashMap<String, Integer>();
        numNames = 0;
        for (int j = 0; j < numFriendships; j++) {
          line = br.readLine().trim().split("\\s+");
          int a = pos(line[0]);
          int b = pos(line[1]);
          System.out.println(uf.union(a, b));
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}