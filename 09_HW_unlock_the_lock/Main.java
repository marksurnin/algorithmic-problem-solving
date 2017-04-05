import java.io.*;
import java.util.*;

public class Main {

  public static int add(int a, int b) {
    // String sum = Integer.toString(a + b);
    String sum = String.format("%04d", a + b);
    sum = sum.substring(sum.length() - 4);
    return Integer.parseInt(sum);
  }

  public static int unlock(int start, int goal, int buttons[]) {
    int[] dist = new int[10000];
    Arrays.fill(dist, -1);
    LinkedList<Integer> queue = new LinkedList<Integer>();
    dist[start] = 0;
    queue.add(start);

    while (!queue.isEmpty()) {
      int current_code = queue.poll();
      for (int i = 0; i < buttons.length; i++) {
        int new_code = (current_code + buttons[i]) % 10000;
        if (dist[new_code] == -1) {
          dist[new_code] = dist[current_code] + 1;
          if (new_code == goal) return dist[new_code];
          queue.add(new_code);
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int caseN = 1;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        String[] tokens = line.trim().split("\\s+");
        int original = Integer.parseInt(tokens[0]);
        int goal = Integer.parseInt(tokens[1]);
        int nButtons = Integer.parseInt(tokens[2]);
        if (original == 0 && goal == 0 && nButtons == 0) break;

        line = br.readLine();
        int[] buttons = new int[nButtons];
        tokens = line.trim().split("\\s+");
        for (int i = 0; i < nButtons; i++) {
          buttons[i] = Integer.parseInt(tokens[i]);
        }

        int numPresses = unlock(original, goal, buttons);
        if (numPresses == -1) {
          System.out.printf("Case %d: Permanently Locked\n", caseN++);
        } else {
          System.out.printf("Case %d: %d\n", caseN++, numPresses);
        }
        // System.out.println(0);
        
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}