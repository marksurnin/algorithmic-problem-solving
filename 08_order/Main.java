import java.io.*;
import java.util.*;

public class Main {

  public static class Graph {
    private int V;
    private int[] indegree;
    private LinkedList<Integer> adj[];
    private TwoWayMap map;

    Graph(int v) {
      V = v;
      adj = new LinkedList[V + 1];
      indegree = new int[V + 1];

      for (int i = 1; i <= V; i++) {
        LinkedList<Integer> out = new LinkedList<Integer>();
        indegree[i] = 0;
        adj[i] = out;
      }
    }

    void setEdge(int a, int b) {
      // System.out.printf("%d %d\n", a, b);
      adj[a].add(b);
      indegree[b]++;
    }

    /*
     * 1. Initialize all vertices as unvisited.
     * 2. Now choose vertex which is unvisited and has zero indegree and decrease indegree
     *    of all those vertices by 1 (corresponding to removing edges) now add this vertex
     *    to result and call the recursive function again and backtrack.
     * 3. After returning from function reset values of visited, result and indegree
     *    for enumeration of other possibilities.
     */

    void doGetAllTopSort(ArrayList<Integer> result, boolean[] visited) {
      boolean allFound = false;
      for (int i = 1; i <= V; i++) {
        if (indegree[i] == 0 && !visited[i]) {
          for (Integer outgoingEdge : adj[i]) {
            indegree[outgoingEdge]--;
          }

          result.add(i);
          visited[i] = true;
          doGetAllTopSort(result, visited);

          // reset values of visited, result and indegree
          visited[i] = false;
          result.remove(result.size() - 1);
          for (Integer outgoingEdge : adj[i]) {
            indegree[outgoingEdge]++;
          }
          allFound = true;
        }
      }

      if (!allFound) {
        if (result.size() == 0) {
          System.out.println("NO");
        } else {
          // Collections.reverse(result);
          int c = 0;
          for (Integer i : result) {
            System.out.print(map.get(i));
            if (c++ < result.size() - 1) System.out.print(" ");
          }
          System.out.print("\n");
        }
      }
    }

    void getAllTopSort() {
      boolean[] visited = new boolean[V+1];
      ArrayList<Integer> result = new ArrayList<Integer>();
      doGetAllTopSort(result, visited);
    }

    void setMap(TwoWayMap newMap) {
      map = newMap;
    }
  }

  public static class TwoWayMap {
    private HashMap<Character, Integer> forward = new HashMap<Character, Integer>();
    private HashMap<Integer, Character> backward = new HashMap<Integer, Character>();
    private int count;

    TwoWayMap() {
      count = 1;
    }

    public int put(Character c) {
      if (!forward.containsKey(c)) {
        forward.put(c, count);
        backward.put(count, c);
        count++;
      }
      return forward.get(c);
    }

    public char get(int i) {
      return backward.get(i);
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    char[][] grid;
    int length;

    try {
      int numTestCases = Integer.parseInt(br.readLine());
      line = br.readLine();
      while (line != null && line.equals("")) {
        TwoWayMap map = new TwoWayMap();

        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        // for (String s : tokens) {
        //   System.out.println(s);
        // }
        Arrays.sort(tokens);
        // for (String s : tokens) {
        //   System.out.println(s);
        // }
        for (String s : tokens) {
          map.put(s.charAt(0));
        }

        Graph g = new Graph(tokens.length);

        line = br.readLine();
        tokens = line.trim().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
          // System.out.println(tokens[i]);
          char before = tokens[i].charAt(0);
          char after = tokens[i].charAt(2);
          g.setEdge(map.put(before), map.put(after));
        }
        g.setMap(map);
        line = br.readLine();


        g.getAllTopSort();
        // if (permutations.size() > 0) {
        //   Iterator<Integer> it = permutations.listIterator();
        //   while (it.hasNext()) {
        //     System.out.println(it.next());
        //   } 
        // }
               
        if (line != null) System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}