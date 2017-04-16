import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        int candidates = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> votes = new PriorityQueue<Integer>(candidates, Collections.reverseOrder());
        
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        int john = Integer.parseInt(tokens[0]);
        for (int j = 1; j < candidates; j++) {
          votes.add(Integer.parseInt(tokens[j]));
        }

        while (john <= votes.peek()) {
          votes.add(votes.poll() - 1);
          john++;
        }
        // int max = votes[0];
        // for (int j = 0; j < candidates - 1; j++) {
        //   if ((votes[j] >= john && j < candidates - 2 && votes[j] >= votes[j+1])) {
        //     votes[j]--;
        //     john++;
        //     max = votes[j];
        //   } else if (votes[j] > john && j < candidates - 2 && votes[j] > votes[j+1])
        // }

        System.out.println(john - Integer.parseInt(tokens[0]));
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}