import java.io.*;
import java.util.*;

public class Main {

  public static class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
      return compareEdge.weight - this.weight;
    }
  }

  public static class Subset {
    int parent, rank;
  }

  public static class Graph {
    public static int V, E;
    public static Edge[] edges;

    Graph(int v, int e) {
      V = v;
      E = e;
      edges = new Edge[E];
      for (int i = 0; i < E; ++i) {
        edges[i] = new Edge();
      }
    }

    int find(Subset[] subsets, int i) {
      if (subsets[i].parent != i) {
        subsets[i].parent = find(subsets, subsets[i].parent);
      }
      return subsets[i].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
      int xroot = find(subsets, x);
      int yroot = find(subsets, y);

      if (subsets[xroot].rank > subsets[yroot].rank) {
        subsets[yroot].parent = xroot;
      } else if (subsets[xroot].rank < subsets[yroot].rank) {
        subsets[xroot].parent = yroot;
      } else {
        subsets[xroot].parent = yroot;
        subsets[yroot].rank++;
      }
    }

    int KruskalMaxSpanTree() {
      Edge[] result = new Edge[V];
      int e = 0;
      int i = 0;
      for (i = 0; i < V; ++i) {
        result[i] = new Edge();
      }

      // this sorts the edges in *decreasing* order (see comparator definition)
      Arrays.sort(edges);

      Subset[] subsets = new Subset[V];
      for (i = 0; i < V; ++i) {
        subsets[i] = new Subset();
      }

      for (int v = 0; v < V; ++v) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
      }

      i = 0;
      while (e < V - 1) {
        Edge next_edge = edges[i++];
        int x = find(subsets, next_edge.src);
        int y = find(subsets, next_edge.dest);

        if (x != y) {
          result[e++] = next_edge;
          Union(subsets, x, y);
        }
      }

      int min_edge = Integer.MAX_VALUE;
      for (i = 0; i < e; ++i) {
        min_edge = Math.min(min_edge, result[i].weight);
        // System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
      }
      return min_edge;
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int test = 0; test < numTestCases; ++test) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int nIntersections = Integer.parseInt(tokens[0]);
        int nRoads = Integer.parseInt(tokens[1]);
        // init graph
        Graph graph = new Graph(nIntersections, nRoads);

        for (int i = 0; i < nRoads; i++) {
          tokens = br.readLine().trim().split("\\s+");
          int src = Integer.parseInt(tokens[0]);
          int dest = Integer.parseInt(tokens[1]);
          int weight = Integer.parseInt(tokens[2]);
          graph.edges[i].src = src;
          graph.edges[i].dest = dest;
          graph.edges[i].weight = weight;
        }

        
        // System.out.printf("Case #%d:\n", test);
        int min_edge = graph.KruskalMaxSpanTree();
        System.out.printf("Case #%d: %d\n", test + 1, min_edge);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}