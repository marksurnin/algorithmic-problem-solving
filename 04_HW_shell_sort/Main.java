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
        int n = Integer.parseInt(br.readLine());
        LinkedList unordered = new LinkedList();
        LinkedList ordered = new LinkedList();

        for (int j = 0; j < n; j++) {
          unordered.addFirst(br.readLine());
        }

        for (int j = 0; j < n; j++) {
          ordered.addFirst(br.readLine());
        }

        ArrayList<String> leftovers = new ArrayList<String>();
        int ordIndex = 0;

        for (int unordIndex = 0; unordIndex < n; unordIndex++) {
          if (unordered.get(unordIndex).equals(ordered.get(ordIndex))) {
            ordIndex++;
          } else {
            leftovers.add(unordered.get(unordIndex).toString());
          }
        }

        for (int j = 0; j < n; j++) {
          if (leftovers.contains(ordered.get(j).toString())) {
            System.out.println(ordered.get(j));
          }
        }

        System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}