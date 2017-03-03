import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int low = 0;
        int high = 0;
        int prev = 0;
        for (int j = 0; j < n; j++) {
          int current = Integer.parseInt(tokens[j + 1]);
          if (current < prev) {
            low = high + 1;
          } else if (current > prev) {
            high = low + 1;
          }
          prev = current;
        }
        System.out.println(Math.max(low, high));
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}