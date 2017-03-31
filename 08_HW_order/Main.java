import java.io.*;
import java.util.*;

public class Main {

  public static class Graph {
    private int V;
    private LinkedList<Integer> incoming[];
    private LinkedList<Integer> outgoing[];
    // boolean[] processed[];

    Graph(int v) {
      V = v;
      incoming = new LinkedList[V + 1];
      outgoing = new LinkedList[V + 1];

      for (int i = 0; i < V; i++) {
        LinkedList<Integer> in = new LinkedList<Integer>();
        LinkedList<Integer> out = new LinkedList<Integer>();
        incoming[i] = in;
        outgoing[i] = out;
      }
    }

    void setEdge(int a, int b) {
      System.out.printf("%d %d\n", a, b);
      outgoing[a].add(b);
      incoming[b].add(a);
    }

    void getAllTopSort() {
      
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
        Graph g = new Graph(tokens.length);

        line = br.readLine();
        tokens = line.trim().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
          System.out.println(tokens[i]);
          char before = tokens[i].charAt(0);
          char after = tokens[i].charAt(2);
          g.setEdge(map.put(before), map.put(after));
        }
        line = br.readLine();


        // ArrayList<Integer> permutations = g.getAllTopSort();
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