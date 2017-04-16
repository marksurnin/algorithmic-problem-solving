import java.io.*;
import java.util.*;

public class Main {

  public static void printSolution(int[] dist, int V, int dest) {
    // System.out.println("Vertex   Distance from Source");
    int min = Integer.MAX_VALUE;
    for (int i = dest; i < V; i+=100) {
      min = Math.min(min, dist[i]);
    }

    if (min == Integer.MAX_VALUE) {
      System.out.println("IMPOSSIBLE");
    } else {
      System.out.println(min);
    }
  }

  public static void printSolution(int dist[], int V) {
    System.out.println("Vertex   Distance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i+" \t\t "+dist[i]);
    }
  }

  public static int minDistance(int[] dist, boolean[] sptSet, int V) {
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int i = 0; i < V; i++) {
      if (!sptSet[i] && dist[i] <= min) {
        min = dist[i];
        min_index = i;
      }
    }
    return min_index;
  }

  public static void dijkstra(int graph[][], int src, int dest) {
    int V = graph.length;
    int dist[] = new int[V];
    // shortest path tree set
    boolean sptSet[] = new boolean[V];
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 0; i < V; i += 100) {
      dist[i] = 0;
    }

    for (int count = 0; count < V-1; count++) {
      int u = minDistance(dist, sptSet, V);
      sptSet[u] = true;

      for (int v = 0; v < V; v++) {
        if (!sptSet[v] && graph[u][v] != 0 &&
            dist[u] != Integer.MAX_VALUE &&
            dist[u] + graph[u][v] < dist[v]) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    printSolution(dist, V, dest);
    // if (dist[dest] == Integer.MAX_VALUE) {
    //   System.out.println("IMPOSSIBLE");
    // } else {
    //   System.out.println(dist[dest]);
    // }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    String[] tokens;

    try {
      line = br.readLine();
      while (line != null) {
        tokens = line.trim().split("\\s+");
        int nElevators = Integer.parseInt(tokens[0]);
        int destFloor = Integer.parseInt(tokens[1]);
        // Graph graph = new Graph(nElevators*100);
        int graph[][] = new int[nElevators*100][nElevators*100];
        // System.out.println(nElevators);

        // store elevator speeds
        tokens = br.readLine().trim().split("\\s+");
        int[] elevators = new int[nElevators];
        for (int i = 0; i < nElevators; i++) {
          elevators[i] = Integer.parseInt(tokens[i]);
        }

        for (int i = 0; i < nElevators; i++) {
          tokens = br.readLine().trim().split("\\s+");
          for (int j = 0; j < tokens.length - 1; j++) {
            int distance = Integer.parseInt(tokens[j+1]) - Integer.parseInt(tokens[j]);
            int time = distance * elevators[i];
            // graph.setEdge(i*100 + Integer.parseInt(tokens[j]), i*100 + Integer.parseInt(tokens[j+1]), time);
            graph[i*100 + Integer.parseInt(tokens[j])][i*100 + Integer.parseInt(tokens[j+1])] = time;
            graph[i*100 + Integer.parseInt(tokens[j+1])][i*100 + Integer.parseInt(tokens[j])] = time;
          }
        }

        // set the weight of the edges on the same floor (diff elevators) to 60
        for (int i = 0; i < nElevators; i++) {
          for (int j = 0; j < nElevators; j++) {
            for (int k = 0; k < 100; k++) {
              if (i != j) {
                // System.out.println(i + " " + j + " " + k);
                // graph.setEdge(k + i*100, k + j*100, 60);
                graph[k + i*100][k + j*100] = 60;
                graph[k + j*100][k + i*100] = 60;
              }
            }
          }
        }

        dijkstra(graph, 0, destFloor);
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}