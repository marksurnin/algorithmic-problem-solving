import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int n = Integer.parseInt(br.readLine());
      // [[flow rate, cost], [...]]
      int[][] dams = new int[n][2];
      line = br.readLine();

      // store information about the dams in memory
      for (int i = 0; i < n; i++) {
        String[] tokens = line.trim().split("\\s+");
        dams[i][0] = Integer.parseInt(tokens[0]); // flow rate
        dams[i][1] = Integer.parseInt(tokens[1]); // cost
                
        line = br.readLine();
      }

      // sort the 2-dimensional dams array by cost
      java.util.Arrays.sort(dams, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          return Double.compare(a[1], b[1]);
        }
      });

      int numTestCases = Integer.parseInt(line.trim());
      
      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        int volume = Integer.parseInt(tokens[0]);
        int time = Integer.parseInt(tokens[1]);

        int sum = 0;
        int cost = 0;
        boolean foundSolution = false;
        // calculate the potential of each dam
        for (int j = 0; j < n; j++) {
          if (sum + dams[j][0] * time >= volume) {
            sum += dams[j][0] * time;
            cost += dams[j][1];
            foundSolution = true;
            for (int k = j - 1; k >= 0; k--) {
              if (sum - dams[k][0] * time >= volume) {
                sum -= dams[k][0] * time;
                cost -= dams[k][1];
              }
            }
            break;
          }

          else {
            sum += dams[j][0] * time;
            cost += dams[j][1];
          }
        }

        System.out.printf("Case %d: ", i+1);
        if (foundSolution) {
          System.out.printf("%d\n", cost);
        } else {
          System.out.printf("IMPOSSIBLE\n");
        }
      }

    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}