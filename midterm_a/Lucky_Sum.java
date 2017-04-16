import java.io.*;
import java.util.*;

public class Lucky_Sum {

  public static int getLucky(int[] tickets, int lucky, HashMap<Integer, Integer> ticketFrequencies, int maxSum) {
    int payout = 0;
    if (lucky > maxSum) {
      return payout;
    }

    for (int i = 0; i < tickets.length; i++) {
      if (ticketFrequencies.containsKey(lucky - tickets[i])) {
        payout += ticketFrequencies.get(lucky - tickets[i]);
        // special case, prevent double counting if a value == lucky/2
        // and is present more than once
        if (lucky - tickets[i] == tickets[i]) {
          payout--;
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
        // number of tickets
        int n = Integer.parseInt(tokens[0]);
        // number of lucky numbers to be analyzed
        int q = Integer.parseInt(tokens[1]);

        tokens = br.readLine().trim().split("\\s+");
        int[] tickets = new int[n];
        HashMap<Integer, Integer> ticketFrequencies = new HashMap<Integer, Integer>();

        for (int j = 0; j < n; j++) {
          tickets[j] = Integer.parseInt(tokens[j]);
          if (!ticketFrequencies.containsKey(tickets[j])) {
            ticketFrequencies.put(tickets[j], 0);
          }
          ticketFrequencies.put(tickets[j], ticketFrequencies.get(tickets[j]) + 1);
        }

        Arrays.sort(tickets);
        int maxSum = tickets[tickets.length-2] + tickets[tickets.length-1];
        
        for (int j = 0; j < q; j++) {
          int lucky = Integer.parseInt(br.readLine());
          System.out.println(getLucky(tickets, lucky, ticketFrequencies, maxSum));
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}