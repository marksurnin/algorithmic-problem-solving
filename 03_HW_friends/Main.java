import java.io.*;
import java.util.*;

public class Main {

  // Disjoint Set implementation adapted from
  // http://www.geeksforgeeks.org/disjoint-set-data-structures-java-implementation/
  private static class UnionFind {
    int[] parents, ranks;
    int n;

    public UnionFind(int n) {
      // given integers A and B are 1 <= A <= N, 1 <= A <= N, thus using 1-based indexing
      parents = new int[n+1];
      ranks = new int[n+1];
      this.n = n;
      fillSet();
    }

    // fill the parents array with values equal to indices
    void fillSet() {
      for (int i = 1; i <= n; i++) {
        // each node is initially a parent of itself
        parents[i] = i;
      }
    }

    void union(int x, int y) {
      int xRoot = find(x);
      int yRoot = find(y);

      // same set, no need to unite anything
      if (xRoot == yRoot)
        return;
      // sove trees around to minimize depth of final tree
      if (ranks[xRoot] < ranks[yRoot]) {
        parents[xRoot] = yRoot;
      } else if (ranks[yRoot] < ranks[xRoot]) {
        parents[yRoot] = xRoot;
      } else if (ranks[xRoot] == ranks[yRoot]) {
        parents[yRoot] = xRoot;
        ranks[xRoot] += 1;
      }
    }

    // find the root of a tree, which a given element belongs to
    int find(int x) {
      if (parents[x] != x) {
        parents[x] = find(parents[x]);
      }
      return parents[x];
    }

    int getMaxCount() {
      int[] counts = new int[n+1];
      // fill the counts array with appropriate values
      for (int i = 1; i < n+1; i++) {
        counts[find(parents[i])] += 1;
      }
      // find maximum of the counts array
      int maxCount = 0;
      for (int i = 1; i < n+1; i++) {
        if (counts[i] > maxCount) {
          maxCount = counts[i];
        }
      }
      return maxCount;
    }

    // helpful for debugging
    void printContents() {
      System.out.print("Parents: ");
      for (int i = 0; i < n+1; i++) {
        System.out.printf("%d ", parents[i]);
      }
      System.out.println();

      System.out.print("Ranks:   ");
      for (int i = 0; i < n+1; i++) {
        System.out.printf("%d ", ranks[i]);
      }
      System.out.println("\n");
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String[] line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine().trim().split("\\s+");
        int numCitizens = Integer.parseInt(line[0]);
        int numPairs = Integer.parseInt(line[1]);

        UnionFind uf = new UnionFind(numCitizens);

        for (int pair = 0; pair < numPairs; pair++) {
          line = br.readLine().trim().split("\\s+");
          int a = Integer.parseInt(line[0]);
          int b = Integer.parseInt(line[1]);
          uf.union(a, b);
        }
        System.out.println(uf.getMaxCount());
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}