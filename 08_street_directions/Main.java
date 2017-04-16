import java.io.*;
import java.util.*;

public class Main {

  public static class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    List<String> pairs;
    int time = 0;

    Graph(int v) {
      V = v;
      adj = new LinkedList[V + 1];
      pairs = new ArrayList<String>();

      for (int i = 1; i <= V; i++) {
        adj[i] = new LinkedList<Integer>();
      }
    }

    void setEdge(int a, int b) {
      // System.out.printf("%d %d\n", a, b);
      adj[a].add(b);
      adj[b].add(a);
    }

    void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
      int children = 0;
      visited[u] = true;
      disc[u] = low[u] = ++time;
      Iterator<Integer> i = adj[u].iterator();
      while (i.hasNext()) {
        int v = i.next();
        if (!visited[v]) {
          parent[v] = u;
          bridgeUtil(v, visited, disc, low, parent);

          // Check if the subtree rooted with v has a
          // connection to one of the ancestors of u
          low[u] = Math.min(low[u], low[v]);

          // If the lowest vertex reachable from subtree
          // under v is below u in DFS tree, then u-v is
          // a bridge
          if (low[v] > disc[u]) {
            System.out.println(u+" "+v);
            System.out.println(v+" "+u);
          } else {
            int min = Math.min(u, v);
            int max = Math.max(u, v);
            System.out.println(u+" "+v);
          }
        }
        // Update low value of u for parent function calls.
        else if (v != parent[u]) {
          low[u] = Math.min(low[u], disc[v]);
          String newPair = v + "_" + u;
          if (!pairs.contains(newPair)) {
            System.out.println(u+" "+v);
            pairs.add(new String(u+"_"+v));
          }
          
        }
      }
    }

    void getBridges() {
      boolean[] visited = new boolean[V+1];
      int disc[] = new int[V+1];
      int low[] = new int[V+1];
      int parent[] = new int[V+1];

      for (int i = 1; i <= V; i++) {
        if (!visited[i]) bridgeUtil(i, visited, disc, low, parent);
      }
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int length;

    try {
      int testCase = 1;
      line = br.readLine();
      while (line != null && !line.equals("")) {
        String[] tokens = line.trim().split("\\s+");
        int numIntersections = Integer.parseInt(tokens[0]);
        int numStreets = Integer.parseInt(tokens[1]);
        if (numIntersections + numStreets == 0) break;
        Graph g = new Graph(numIntersections);

        for (int i = 0; i < numStreets; i++) {
          line = br.readLine();
          tokens = line.trim().split("\\s+");
          int a = Integer.parseInt(tokens[0]);
          int b = Integer.parseInt(tokens[1]);
          g.setEdge(a, b);
        }

        System.out.println(testCase++);
        System.out.println();
        g.getBridges();
        System.out.println("#");

        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}