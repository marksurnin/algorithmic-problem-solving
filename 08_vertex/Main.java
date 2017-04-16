import java.io.*;
import java.util.*;

public class Main {

  public static class Graph {
    // number of vertices
    private int V;
    // array of adjacency lists for each vertex
    private LinkedList<Integer> adj[];

    Graph(int v) {
      V = v;
      adj = new LinkedList[v+1];
      for (int i = 1; i <= V; i++) {
        adj[i] = new LinkedList();
      }
    }

    void addEdge(int start, int end) {
      // System.out.printf("%d %d\n", start, end);
      adj[start].add(end);
    }

    void do_DFS(int v, boolean[] visited, boolean first) {
      if (!first) visited[v] = true;
      else first = false;
      for (int i = 0; i < adj[v].size(); i++) {
        if (!visited[adj[v].get(i)]) {
          do_DFS(adj[v].get(i), visited, first);
        }
      }
    }

    LinkedList<Integer> DFS(int startVertex) {
      // needed to mark the first vertex as unvisited
      boolean first = true;
      boolean[] visited = new boolean[V+1];
      do_DFS(startVertex, visited, first);
      // compute the number of unvisited vertices
      LinkedList<Integer> unvisited = new LinkedList<Integer>();
      for (int i = 1; i <= V; i++) {
        if (!visited[i]) {
          unvisited.add(i);
        }
      }
      return unvisited;
    }
  }

  public static void printInaccessible(LinkedList<Integer> unvisited) {
    System.out.print(unvisited.size());
    for (int i = 0; i < unvisited.size(); i++) {
      System.out.printf(" %d", unvisited.get(i));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    String[] tokens;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        int n = Integer.parseInt(line);
        line = br.readLine();
        Graph G = new Graph(n);

        while (!line.equals("0")) {
          tokens = line.trim().split("\\s+");
          int start = Integer.parseInt(tokens[0]);
          for (int i = 1; i < tokens.length - 1; i++) {
            int end = Integer.parseInt(tokens[i]);
            G.addEdge(start, end);
          }
          line = br.readLine();
        }

        line = br.readLine();
        tokens = line.trim().split("\\s+");
        int numStartVertices = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
          int startVertex = Integer.parseInt(tokens[i]);
          LinkedList<Integer> unvisited = G.DFS(startVertex);
          printInaccessible(unvisited);
        }
        // skip 0
        // System.out.println(0);
        line = br.readLine();
        if (line.equals("0")) break;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}