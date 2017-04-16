import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    int n = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < n; i++) {
      int stops = Integer.parseInt(br.readLine().trim());
      int sum = 0, ans = 0, start = 1, startMax = 1, end = 1;
      for (int stop = 1; stop < stops; stop++) {
        int value = Integer.parseInt(br.readLine().trim());
        sum += value;
        // select the longest nicest segment and break ties by the earliest starting point
        if (ans < sum || (sum == ans && stop - start > end - startMax)) {
          ans = sum;
          end = stop + 1;
          startMax = start;
        }
        if (sum < 0) {
          sum = 0;
          start = stop + 1;
        }
      }
      if (ans > 0) {
        System.out.printf("The nicest part of route %d is between stops %d and %d\n", i+1, startMax, end);
      } else {
        System.out.printf("Route %d has no nice parts\n", i+1);
      }
    }
  }
}