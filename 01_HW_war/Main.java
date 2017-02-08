import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Main {

  Map<Integer, String> hm = new HashMap();

  public static void setFriends(int a, int b) {
    if (!hm.containsKey(a) && !hm.containsKey(b))
  }

  public static void setEnemies(int a, int b) {
    System.out.println(a + b);
  }

  public static void areFriends(int a, int b) {
    System.out.println(a + b);
  }

  public static void areEnemies(int a, int b) {
    System.out.println(a + b);
  }

  public static void main(String[] args) {

      // set up I/O
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);

      String line;
      // number of people
      Integer n, operation, p1, p2;

      try {

        line = br.readLine();
        n = Integer.parseInt(line);
        if (n < 1 || n >= 10000) {
          System.out.println("Invalid value of number of people.");
          System.exit(1);
        }

        // advance to the commands
        line = br.readLine().trim();
        while (line != null && line.length() != 0) {
          String[] tokens = line.trim().split("\\s+");
          operation = Integer.parseInt(tokens[0]);
          p1 = Integer.parseInt(tokens[1]);
          p2 = Integer.parseInt(tokens[2]);

          if (operation == 0) {
            break;
          }

          if (operation == 1) {
            setFriends(p1, p2); 
          } else if (operation == 2) {
            setEnemies(p1, p2); 
          } else if (operation == 3) {
            areFriends(p1, p2); 
          } else if (operation == 4) {
            areEnemies(p1, p2); 
          }

          line = br.readLine();
        }

      } catch (IOException e) {
        e.printStackTrace();
      }

  }

}