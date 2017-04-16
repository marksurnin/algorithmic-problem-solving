import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line;
    int numTestCases = sc.nextInt();;
    
    for (int i = 0; i < numTestCases; i++) {
      int length = sc.nextInt();
      int numAnts = sc.nextInt();
      int earliest = 0;
      int latest = 0;
      for (int j = 0; j < numAnts; j++) {
        int current = sc.nextInt();
        // make current = distance to the closest edge
        if (current > length / 2) current = length - current;
        // update earliest if there is an ant that
        // will take longer to get to the closer edge
        earliest = Math.max(earliest, current);
        // update latest if there is an ant that
        // will take longer to get to the farther edge
        latest = Math.max(latest, length - current);
      }
      System.out.printf("%d %d\n", earliest, latest);
    }
  }
}