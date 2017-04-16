import java.io.*;
import java.util.*;

public class Lucky_Sum {

  public static int getLucky(int[] tickets, int lucky, int maxSum) {
    int payout = 0;

    if (lucky > maxSum) {
      return payout;
    }

    for (int i = 0; i < tickets.length; i++) {
      for (int j = 0; j < tickets.length; j++) {
        if (i != j && tickets[i] + tickets[j] == lucky) {
          // System.out.printf("pair: %d, %d\n", tickets[i], tickets[j]);
          payout++;
        }
      }
    }

    return payout / 2;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        String[] tokens = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);

        tokens = br.readLine().trim().split("\\s+");
        int[] tickets = new int[n];
        for (int j = 0; j < n; j++) {
          tickets[j] = Integer.parseInt(tokens[j]);
        }

        Arrays.sort(tickets);
        
        int maxSum = tickets[tickets.length-2] + tickets[tickets.length-1];

        for (int j = 0; j < q; j++) {
          int lucky = Integer.parseInt(br.readLine());
          System.out.println(getLucky(tickets, lucky, maxSum));
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}