import java.io.*;
import java.util.*;

public class Main {

  public static int n;
  public static int m;
  public static int[] vessels;

  public static boolean tryCapacity(int maxCapacity) {
    int total = 0, current = 0;
    for (int i = 0; i < n; i++) {
      if (vessels[i] > maxCapacity) return false;
      if (current + vessels[i] > maxCapacity) current = 0;
      if (current == 0) total++;
      if (total > m) return false;
      current += vessels[i];
    }
    return true;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        String[] tokens = line.trim().split("\\s+");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        vessels = new int[n];

        tokens = br.readLine().trim().split("\\s+");
        int lo = 1;
        int hi = 0;
        int mid;
        for (int i = 0; i < n; i++) {
          vessels[i] = Integer.parseInt(tokens[i]);
          hi += vessels[i];
        }

        int best = hi + 1;
        while (lo <= hi) {
          mid = lo + (hi - lo) / 2;
          if (tryCapacity(mid)) {
            best = mid;
            hi = mid - 1;
          } else {
            lo = mid + 1;
          }
        }

        System.out.println(best);
        
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}