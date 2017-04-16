import java.io.*;
import java.util.*;

public class Main {

  public static int[] stalls;

  public static int binarySearch(int c) {
    int start = 0;
    int end = stalls.length - 1;
    int distance = stalls[end] - stalls[start];
    if (c = 2) {
      return distance;
    }
    if (c > 2)
    while (c--) {

    }
    return distance;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());
      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        stalls = new int[n];

        for (int j = 0; j < n; j++) {
          line = br.readLine();
          stalls[j] = Integer.parseInt(line);
        }

        Arrays.sort(stalls);

        int minDistance = binarySearch(3);

        System.out.println(minDistance);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}