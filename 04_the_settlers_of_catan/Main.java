import java.io.*;
import java.util.*;

public class Main {

  public static boolean[][] map;
  public static boolean[][] visited;
  public static int numNodes, numEdges;

  public static int dfs(int i) {
    int result = 0;
    for (int j = 0; j < numNodes; j++) {
      if (map[i][j] == true && visited[i][j] == false) {
        visited[i][j] = visited[j][i] = true;
        result = Math.max(result, dfs(j) + 1);
        visited[i][j] = visited[j][i] = false;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        String[] tokens = line.trim().split("\\s+");

        numNodes = Integer.parseInt(tokens[0]);
        numEdges = Integer.parseInt(tokens[1]);

        // this signifies "0 0", end of input
        if (numNodes == 0 && numEdges == 0) {
          break;
        }

        map = new boolean[numNodes][numNodes];
        visited = new boolean[numNodes][numNodes];

        for (int i = 0; i < numEdges; i++) {
          line = br.readLine();
          tokens = line.trim().split("\\s+");
          int a = Integer.parseInt(tokens[0]);
          int b = Integer.parseInt(tokens[1]);
          map[a][b] = true;
          map[b][a] = true;
        }

        int ans = 0;
        for (int i = 0; i < numNodes; i++) {
          ans = Math.max(ans, dfs(i));
        }
        
        System.out.println(ans);
        numNodes = 0;
        numEdges = 0;
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}