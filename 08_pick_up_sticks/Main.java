import java.io.*;
import java.util.*;

public class Main {

  public static class Graph {
    private int V;
    private LinkedList<Integer> outgoing[];
    private LinkedList<Integer> incoming[];
    boolean[] processed;

    Graph(int v) {
      V = v;
      processed = new boolean[V + 1];
      outgoing = new LinkedList[V + 1];
      incoming = new LinkedList[V + 1];

      for (int i = 1; i <= V; i++) {
        LinkedList<Integer> out = new LinkedList<Integer>();
        LinkedList<Integer> in = new LinkedList<Integer>();
        outgoing[i] = out;
        incoming[i] = in;
      }
    }

    void setEdge(int a, int b) {
      outgoing[a].add(b);
      incoming[b].add(a);
    }

    ArrayList<Integer> getVerticesWithNoIncomingEdges() {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      // add vertices with 0 incoming edges to the queue
      for (int i = 1; i <= V; i++) {
        if (incoming[i].size() == 0 && !processed[i]) {
          temp.add(i);
        }
      }
      return temp;
    }

    // Kahn's algorithm for topological sort
    ArrayList<Integer> topSort() {
      ArrayList<Integer> sorted = new ArrayList<Integer>();
      Queue<Integer> q = new LinkedList<Integer>();

      ArrayList<Integer> verticesWithNoIncomingEdges = getVerticesWithNoIncomingEdges();
      Iterator<Integer> iter = verticesWithNoIncomingEdges.listIterator();
      while (iter.hasNext()) {
        q.add(iter.next());
      }

      while (!q.isEmpty()) {
        int temp = q.poll();
        processed[temp] = true;
        LinkedList<Integer> out = outgoing[temp];
        Iterator<Integer> it = out.listIterator();
        while (it.hasNext()) {
          int outgoingEdge = it.next();
          it.remove();
          incoming[outgoingEdge].remove(new Integer(temp));
          if (incoming[outgoingEdge].size() == 0) {
            q.add(outgoingEdge);
          }
        }
        sorted.add(temp);
      }
      return sorted;
    }
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null) {
        String[] tokens = line.trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        // end of input
        if (n + m == 0) break;

        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
          tokens = br.readLine().trim().split("\\s+");
          int a = Integer.parseInt(tokens[0]);
          int b = Integer.parseInt(tokens[1]);
          g.setEdge(a, b);
        }

        ArrayList<Integer> sorted = g.topSort();
        if (sorted.size() > 0) {
          Iterator<Integer> it = sorted.listIterator();
          while (it.hasNext()) {
            System.out.println(it.next());
          } 
        } else {
          System.out.println("IMPOSSIBLE");
        }
        
        line = br.readLine();
      }
        
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}