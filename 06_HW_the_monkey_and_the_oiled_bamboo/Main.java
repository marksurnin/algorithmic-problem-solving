import java.io.*;
import java.util.*;

public class Main {

  public static boolean can(int[] rungs, int k) {
    int curr = 0;
    for (int i = 0; i < rungs.length; i++) {
      if (rungs[i] - curr > k) return false;
      if (rungs[i] - curr == k) k--;
      curr = rungs[i];
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int numTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < numTestCases; i++) {
      int n = Integer.parseInt(br.readLine());
      String[] tokens = br.readLine().trim().split("\\s+");
      int[] rungs = new int[n];
      int lastRung = 0;
      int maxGap = 1;
      for (int j = 0; j < n; j++) {
        rungs[j] = Integer.parseInt(tokens[j]);
        int currentGap = rungs[j] - lastRung;
        maxGap = Math.max(currentGap, maxGap);
        lastRung = rungs[j];
      }

      // binary search the answer
      int lo = maxGap;
      int hi = 1000000;
      int mid = 0, ans = 0;
      while (lo <= hi) {
        mid = (lo + hi)/2;
        if (can(rungs, mid)) {
          ans = mid;
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }

      System.out.printf("Case %d: %d\n", i+1, ans);
    }
  }
}