import java.io.*;
import java.util.*;

public class Main {

  public static boolean endings[];

  public static class Graph {
    private int V;   // No. of vertices
    public int favourable;
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }
 
    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            System.out.printf("n: %d\n", n);
            // if (n == 101) {
            if (n == 1) {
              System.out.println("hey");
              favourable++;
              return;
            }
            //if (!visited[n]) {
              DFSUtil(n, visited);
              // System.out.println();
              // System.out.println(n);
              // System.out.println();
              
            //}
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int s = Integer.parseInt(br.readLine());
      Graph g = new Graph(401);
      endings = new boolean[401];
      int counter = 0;

      if (s < 4) {
        for (int j = 0; j < s; j++) {
          String[] tokens = br.readLine().trim().split("\\s+");
          if (tokens[1].equals("favourably")) {
            counter++;
          }
        }
        System.out.println(counter);
      } else {
        for (int j = 0; j < s; j++) {
          String[] tokens = br.readLine().trim().split("\\s+");
          // if it is a split
          if (tokens.length > 1 && Character.isDigit(tokens[1].charAt(0))) {
            int split = Integer.parseInt(tokens[0]);
            int option1 = Integer.parseInt(tokens[1]);
            int option2 = Integer.parseInt(tokens[2]);
            int option3 = Integer.parseInt(tokens[3]);
            g.addEdge(option1, split);
            g.addEdge(option2, split);
            g.addEdge(option3, split);
          }
          // if it is an ending
          else {
            if (tokens[1].equals("favourably")) {
              int ending = Integer.parseInt(tokens[0]);
              // System.out.println(ending);
              endings[ending] = true;
              // 0 means favourable ending
              //g.addEdge(ending, s);
            }
          }
        }

        for (int j = 0; j < 401; j++) {
          if (endings[j]) {
            // System.out.printf("j: %d\n", j);

            g.DFS(j);
          }
        }

        System.out.println(g.favourable);
      }
    }
  }
}