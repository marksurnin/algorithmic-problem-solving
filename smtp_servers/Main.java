import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class Main {

  public static class Graph {
    // number of vertices
    private int V;
    // array of adjacency lists for each vertex
    // private LinkedList<Integer> adj[];
    public  LinkedList< Pair<Integer, Integer> >[] adj;

    Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      for (int i = 0; i < V; i++) {
        adj[i] = new LinkedList();
      }
    }

    void addEdge(int start, int end, int weight) {
      // System.out.println(start + " " + end + " " + weight);
       // System.out.println(adj[start]);
      // System.out.printf("%d %d\n", start, end);
      // adj[start].add(end);
      adj[start].add(new Pair<>(end, weight));
    }
  }

  // A utility function to find the vertex with minimum distance value,
  // from the set of vertices not yet included in shortest path tree
  static int V;
  static int casen;
  public static int minDistance(Graph g, int dist[], Boolean sptSet[])
  {
      // Initialize min value
      int min = Integer.MAX_VALUE, min_index=-1;

      for (int v = 0; v < g.adj[v].size(); v++) {
        if (sptSet[v] == false && dist[v] <= min) {
          min = dist[v];
          min_index = v;
        }
      }

      return min_index;
  }

  // Funtion that implements Dijkstra's single source shortest path
  // algorithm for a graph represented using adjacency matrix
  // representation
  public static void dijkstra(Graph g, int src, int sink)
  {
      int dist[] = new int[V]; // The output array. dist[i] will hold
                               // the shortest distance from src to i

      // sptSet[i] will true if vertex i is included in shortest
      // path tree or shortest distance from src to i is finalized
      Boolean sptSet[] = new Boolean[V];

      // Initialize all distances as INFINITE and stpSet[] as false
      for (int i = 0; i < V; i++)
      {
          dist[i] = Integer.MAX_VALUE;
          sptSet[i] = false;
      }

      // Distance of source vertex from itself is always 0
      dist[src] = 0;

      // Find shortest path for all vertices
      for (int count = 0; count < V-1; count++)
      {
          // Pick the minimum distance vertex from the set of vertices
          // not yet processed. u is always equal to src in first
          // iteration.
          int u = minDistance(g, dist, sptSet);
          System.out.println(u);

          // Mark the picked vertex as processed
          sptSet[u] = true;

          for (int v = 0; v < g.adj[u].size(); v++) {
            if (!sptSet[v] &&
              dist[u] != Integer.MAX_VALUE && dist[u] + g.adj[u].get(v).getValue() < dist[v]) {
              dist[v] = dist[u] + g.adj[u].get(v).getValue();
            }
          }

      }

      // print the constructed distance array
      // printSolution(dist, V);
      if (dist[sink] < 0) {
        System.out.printf("Case #%d: unreachable\n", casen);
      } else {
        System.out.printf("Case #%d: %d\n", casen, dist[sink]);
      }
      // System.out.println();
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    casen = 0;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int s = Integer.parseInt(tokens[2]);
        int t = Integer.parseInt(tokens[3]);

        // int[][] graph = new int[n][n];
        Graph g = new Graph(n);
        // for (int[] row : graph) {
        //   Arrays.fill(row, -1);
        // }

        for (int edge = 0; edge < m; edge++) {
          tokens = br.readLine().trim().split("\\s+");
          int a = Integer.parseInt(tokens[0]);
          int b = Integer.parseInt(tokens[1]);
          int weight = Integer.parseInt(tokens[2]);
          g.addEdge(a, b, weight);
          g.addEdge(b, a, weight);
          // graph[a][b] = weight;
          // graph[b][a] = weight;
        }

        V = n;
        casen++;
        dijkstra(g, s, t);

        // System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}