// package uva.backup;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * uva 259 , maximum flow, max flow
 * 
 */

public class Main {
  static boolean debug = false;
  static int source = 37, target = 38;
  static int[][] adjMatric = new int[45][45];
  static LinkedList<Integer>[] adjList = new LinkedList[45];

  static int max_flow() {
    int res = 0;
    while (true) {
      int pathCap = findPath();
      if (pathCap == 0)
        break;
      else
        res += pathCap;
    }
    return res;
  }

  static int findPath() {
    Queue<Integer> q = new LinkedList<Integer>();
    boolean[] visited = new boolean[adjList.length];
    q.add(source);
    visited[source] = true;
    int[] path = new int[adjList.length];
    Arrays.fill(path, -1);
    boolean foundTarget = false;
    while (!q.isEmpty()) {
      int curr = q.poll();

      for (int to = 0; to < adjList.length; to++) {
        if (adjMatric[curr][to] > 0 && !visited[to]) {
          q.add(to);
          visited[to] = true;
          path[to] = curr;
          if (to == target) {
            foundTarget = true;
            break;
          }
        }
      }
      if (foundTarget)
        break;
    }
    int where = target;
    int prev;
    int pathCap = 1 << 30;
    while (path[where] > -1) {
      prev = path[where];
      pathCap = Math.min(pathCap, adjMatric[prev][where]);
      where = prev;
    }

    where = target;

    if (pathCap == 1 << 30)
      return 0;

    while (path[where] > -1) {
      prev = path[where];
      adjMatric[prev][where] -= pathCap;
      adjMatric[where][prev] += pathCap;
      where = prev;
    }

    return pathCap;

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = null;
    if (debug) {
      br = new BufferedReader(new FileReader("C:\\Dev4Workspace\\Test\\in.txt"));
    } else {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    StringBuilder out = new StringBuilder();
    String[] sp;
    String l;
    for (int i = 0; i < adjList.length; i++) {
      adjList[i] = new LinkedList<Integer>();
    }
    while (true) {
      for (int i = 0; i < adjList.length; i++) {
        Arrays.fill(adjMatric[i], 0);
        adjList[i].clear();
      }

      int dist = 0;
      l = br.readLine();
      while (l != null && !l.matches("")) {
        sp = l.split(" ");
        int app = sp[0].charAt(0) - 'A';
        adjMatric[source][app] = sp[0].charAt(1) - '0';
        dist += sp[0].charAt(1) - '0';
        for (int i = 0; i < sp[1].length() - 1; i++) {
          int comp = sp[1].charAt(i) - '0';
          adjMatric[app][comp + 26] = 1;
          adjMatric[comp + 26][target] = 1;
          adjList[app].add(comp);
        }
        l = br.readLine();
      }

      int res = max_flow();

      if (res != dist)
        out.append("!\n");
      else {
        char[] output = new char[10];

        Arrays.fill(output, '_');

        for (int i = 0; i < 26; i++) {
          for (int j : adjList[i]) {
            if (adjMatric[i][j + 26] == 0)
              output[j] = (char) (i + 'A');
          }
        }
        out.append(new String(output) + "\n");
      }

      if (l == null)
        break;
    }

    System.out.print(out);
  }
}