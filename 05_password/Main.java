import java.io.*;
import java.util.*;

public class Main {

  public static String[][] roll;

  // public static void count(String myString, String myString1) {
  //   int i = 0;
  //   int count = 0;
  //   int length = myString.length() < myString1.length() ? myString.length() : myString1.length();
  //   while(i < length) {
  //       if(myString.charAt(i) == myString1.charAt(i)) {
  //           count++;
  //       }
  //       i++;
  //   }
  //   System.out.println("Count is :: " + count);
  // }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());
      for (int i = 0; i < numTestCases; i++) {
        int k = Integer.parseInt(br.readLine());

        roll = new String[2][6];
        for (int j = 0; j < 2; j++) {
          for (int l = 0; l < 12; l++) {
          line = br.readLine();
          roll[j][l] = line;
        }

        Set<Character> set1 = new Set<Character>();
        Set<Character> set2 = new Set<Character>();        

        Character[][] arr 
        // compute common letters
        for (int x = 0; x < 6; x++) {
          for (int z = 0; z < 6; z++) {
            set1.add(roll[0][z].charAt(x));
          }
          for (int z = 0; z < 6; z++) {
            set2.add(roll[1][z].charAt(x));
          }
          set1.retainAll(set2);
          set1.toArray();
          for (int u = 0; u < set1.size(); u++) {
            u 
          }

        }

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