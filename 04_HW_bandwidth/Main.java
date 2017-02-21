import java.io.*;
import java.util.*;

public class Main {

  private static class AdjacencyList {
    private HashMap<Character, ArrayList<Character>> hm = new HashMap<Character, ArrayList<Character>>();

    public AdjacencyList() {
      
    }

    public void setEdge(Character a, Character b) {
      // a
      if (!hm.containsKey(a)) {
        // no ArrayList assigned, create a new ArrayList
        hm.put(a, new ArrayList<Character>());
      }
      // add value to the list
      hm.get(a).add(b);

      // b
      if (!hm.containsKey(b)) {
        hm.put(b, new ArrayList<Character>());
      }
      hm.get(b).add(a);
    }

    public ArrayList<Character> getConnections(Character a) {
      return(hm.get(a));
    }

    public Set<Character> keySet() {
      return hm.keySet();
    }

    public void clear() {
      hm.clear();
    }
  }

  // global variables are ok in competitive programming, yeah? :)
  static ArrayList <String> permutations = new ArrayList <String>();
  static AdjacencyList al = new AdjacencyList();

  // initial call to the recursive function
  public static void generatePermutations(String word) {
    generatePermutations("", word);
  }

  // recursively generate permutations of a string
  public static void generatePermutations(String perm, String word) {
    int n = word.length();
    if (word.isEmpty()) {
      // System.out.printf("%s %s\n", perm, word);
      permutations.add(perm + word);
    } else {
      for (int i = 0; i < n; i++) {
        generatePermutations(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1, n));
      }
    }
  }

  /* The bandwidth of a node v is defined as the maximum distance in the ordering
   * between v and any node to which it is connected in the graph. The bandwidth
   * of the ordering is then defined as the maximum of the individual bandwidths.
   */
  public static int bandwidth(String str) {
    int maxDistance = 0;

    for (int i = 0; i < str.length(); i++) {
      ArrayList<Character> connections = al.getConnections(str.charAt(i));
      for (int j = 0; j < connections.size(); j++) {
        int curDistance = Math.abs(i - str.indexOf(connections.get(j)));
        if (curDistance > maxDistance) {
          maxDistance = curDistance;
        }
      }
    }
    return maxDistance;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        // this signifies `#`, end of input
        if (line.length() == 1) {
          break;
        }

        String[] tokens = line.trim().split(";");

        // build an adjacency list
        for (String s : tokens) {
          Character vertex = s.charAt(0);
          String connections = s.substring(2);

          for (int i = 0; i < connections.length(); i++) {
            al.setEdge(vertex, connections.charAt(i));
          }
        }

        // generate all permutations (since 8! ~ 40000)
        StringBuilder sb = new StringBuilder();
        for (Character c : al.keySet()) {
          sb.append(Character.toString(c));
        }

        // important to sort to maintain lexicographic order
        String nodes = sb.toString();
        char[] ar = nodes.toCharArray();
        Arrays.sort(ar);
        String sortedNodes = String.valueOf(ar);
        generatePermutations(sortedNodes);

        // find the permutation with the lowest bandwidth
        int minBandwidth = 10;
        int minIndex = 0;
        for (int i = 0; i < permutations.size(); i++) {
          int curBandwidth = bandwidth(permutations.get(i));
          if (curBandwidth < minBandwidth) {
            minBandwidth = curBandwidth;
            minIndex = i;
          }
        }

        String bestPermutation = permutations.get(minIndex);
        bestPermutation = bestPermutation.replace("", " ").trim();
        System.out.printf("%s -> %d\n", bestPermutation, minBandwidth);

        // clear the adjacency list and permutations ArrayList
        al.clear();
        permutations.clear();
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}