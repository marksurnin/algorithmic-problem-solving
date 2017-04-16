import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String[] line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine().trim().split("\\s+");
        int numParties = Integer.parseInt(line[0]);
        int[] parties = new int[numParties];
        int totalNumVotes = 0;

        for (int j = 0; j < numParties; j++) {
          parties[j] = Integer.parseInt(line[j+1]);
          totalNumVotes += parties[j];
        }

        // generate all subsets
        for (int j = 0; j < (1 << numParties); j++) { 
          // System.out.print("{ ");
          for (int k = 0; k < numParties; k++) {
            if ((j & (1 << k)) > 0) {
              System.out.print(parties[k] + " ");
            }
          }
          System.out.println();
        }

        int majority = totalNumVotes/2 + 1;


        // System.out.println(totalNumVotes);
        // System.out.println(majority);
        // System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}