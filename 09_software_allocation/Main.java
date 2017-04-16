import java.io.*;
import java.util.*;

public class Main {
  static int nJobs = 26;
  static int nComputers = 10;
  static int flow;

  public static boolean bfs(int[][] graph, int source, int sink, int[] parent) {
    boolean[] visited = new boolean[graph.length];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[source] = true;
    queue.add(source);

    while (!queue.isEmpty()) {
      int temp = queue.poll();
      for (int i = 0; i < graph.length; i++) {
        if (visited[i] == false && graph[temp][i] > 0) {
          queue.add(i);
          parent[i] = temp;
          visited[i] = true;
        }
      }
    }

    return (visited[sink] == true);
  }

  public static int edmondsKarp(int[][] original_graph, int[][] g, int source, int sink, int total, HashMap<Character, Integer> original_map, LinkedList<Integer> positions[]) {
    int maxFlow = 0;
    int[] parent = new int[g.length];

    int[][] graph = new int[g.length][g.length];
    for (int row = 0; row < graph.length; row++) {
      for (int col = 0; col < graph.length; col++) {
        graph[row][col] = g[row][col];
      }
    }

    while (bfs(graph, source, sink, parent)) {
      int minEdge = Integer.MAX_VALUE;
      for (int i = sink; i != source; i = parent[i]) {
        int p = parent[i];
        minEdge = Math.min(minEdge, graph[p][i]); //?
      }

      for (int i = sink; i != source; i = parent[i]) {
        int p = parent[i];
        graph[p][i] -= minEdge;
        graph[i][p] += minEdge;
      }

      maxFlow += minEdge;
    }

    StringBuilder sb = new StringBuilder();
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

    if (maxFlow == total) {
      boolean found;
      for (int j = 0; j < 10; j++) {
        found = false;
        for (int i = 10; i < 37; i++) {
          if (graph[i][j] == 0) {
            // System.out.printf("%c", 'A' + i - 10);
            char temp = (char) ('A' + i - 10);
            // Character.forDigit('A' + i - 10, 10)
            if (!hm.containsKey(temp)) hm.put(temp, 0);
            hm.put(temp, hm.get(temp) + 1);
            sb.append(temp);
            found = true;
            break;
          }
        }
        if (!found) {
          // System.out.print("_");
          sb.append("_");
          found = false;
        }
      }
      if (checkGraph(original_map, hm, sb, original_graph, positions)) {
        System.out.println(sb);
      } else {
        System.out.println("!");
      }
    }
    else {
      System.out.println("!");
    }
    return maxFlow;
  }

  public static boolean checkGraph(HashMap<Character, Integer> original_map, HashMap<Character, Integer> hm, StringBuilder sb, int[][] original_graph, LinkedList<Integer> positions[]) {
    for (Character key : original_map.keySet()) {
      if (original_map.get(key) != hm.get(key)) return false;
    }

    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) != '_') {
        int jobNumeric = Character.getNumericValue(sb.charAt(i));
        // System.out.println(jobNumeric);
        if (original_graph[i][jobNumeric] != 1) {
          return false;
        }
        System.out.println(positions[i].contains(jobNumeric));
        if (!positions[i].contains(jobNumeric)) {
          return false;
        }
      }
    }
    return true;
  }

  public static int maxFlow(int[][] graph, int source, int sink) {
    int V = graph.length;
    int maxFlow = 0;
    while (true) {
      flow = 0;
      boolean[] visited = new boolean[V];
      visited[source] = true;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(source);

      int[] parent = new int[V];
      for (int i = 0; i < V; i++) {
        parent[i] = -1;
      }

      while(!q.isEmpty()) {
        int u = q.remove();
        if (u == sink) break;
        for (int v = 0; v < V; v++) {
          if (graph[u][v] > 0 && !visited[v]) {
            visited[v] = true;
            q.add(v);
            parent[v] = u;
          }
        }
      }

      augment(graph, source, sink, Integer.MAX_VALUE, parent);
      if (flow == 0) break;
      maxFlow += flow;
    }
    return maxFlow;
  }

  public static void augment(int[][] graph, int source, int sink, int minEdge, int[] parent) {
    if (sink == source) { //
      flow = minEdge;
      return;
    } else if (parent[sink] != -1) {
      augment(graph, source, parent[sink], Math.min(minEdge, graph[parent[sink]][sink]), parent);
      graph[parent[sink]][sink] -= flow;
      graph[sink][parent[sink]] += flow;
    }
  }

  public static int[] getMatching(int[][] graph) {
    int[] matching = new int[nComputers];
    for (int computer = nJobs + 1; computer < graph.length - 1; computer++) {
      for (int app = 1; app < nJobs + 1; app++) {
        if (graph[computer][app] == 1) {
          matching[computer - nJobs - 1] = app;
        }
      }
    }
    // System.out.println(Arrays.toString(matching));
    return matching;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null) {
        int V = nJobs + nComputers + 2;
        int source = 0;
        int sink = V - 1;
        int[][] graph = new int[V][V];
        int totalJobs = 0;

        while (line != null && !line.equals("")) {
          String[] tokens = line.trim().split("\\s+");
          int jobNumeric = tokens[0].charAt(0) - 'A' + 1;
          int numJobs = Character.getNumericValue(tokens[0].charAt(1));
          totalJobs += numJobs;
          graph[source][jobNumeric] = numJobs;

          for (char c : tokens[1].replace(";", "").toCharArray()) {
            int computer = c - '0' + nJobs + 1;
            // System.out.println(jobNumeric + " " + computer);
            graph[jobNumeric][computer] = Integer.MAX_VALUE;
          }
          line = br.readLine();
        }

        for (int v = nJobs + 1; v < V - 1; v++) {
          graph[v][sink] = 1;
        }
        
        int maxFlow = maxFlow(graph, source, sink);

        // print solution
        if (maxFlow < totalJobs) {
          System.out.println("!");
        } else {
          // int[] matching = getMatching(graph);
          // for (int i = 0; i < matching.length; i++) {
          //   if (matching[i] == 0) System.out.print("_");
          //   else System.out.print((char) matching[i] - 1 + 'A');
          // }
          // System.out.println();
          int[] matching = getMatching(graph);
          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < matching.length; i++){
            if(matching[i] == 0) sb.append("_");
            else{
              sb.append((char)(matching[i] - 1 + 'A'));
            }
          }
          System.out.println(sb.toString());
        }

        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}