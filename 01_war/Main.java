import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Main {

  private static class UF {
    private int[] data;

    public UF(int n) {
      data = new int[n];
      for (int i = 0; i < n; i++) {
        data[i] = i;
      }
    }

    public void setFriends(int a, int b) {
      if (data[a] != a || data[b] != b) {
        if (data[a] == data[b])
          System.out.println(-1);
      }
      int a_id = data[a];
      int b_id = data[b];
      for (int i = 0; i < data.length; i++) {
        if (data[i] == a_id)
          data[i] = b_id;
      }
    }

    public void setEnemies(int a, int b) {
      if (data[a] == data[b])
        System.out.println(-1);
    }

    public void areFriends(int a, int b) {
      if (data[a] == data[b]) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

    public void areEnemies(int a, int b) {
      if (data[a] != data[b]) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

    public void printContents() {
      for (int i : data) {
        System.out.printf("%d ", i);
      }
      System.out.println();
    }
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

        UF uf = new UF(n);

        // advance to the commands
        line = br.readLine().trim();
        while (line != null && line.length() != 0) {
          String[] tokens = line.trim().split("\\s+");
          operation = Integer.parseInt(tokens[0]);
          p1 = Integer.parseInt(tokens[1]);
          p2 = Integer.parseInt(tokens[2]);

          uf.printContents();

          if (operation == 0) {
            break;
          }

          if (operation == 1) {
            uf.setFriends(p1, p2);
          } else if (operation == 2) {
            uf.setEnemies(p1, p2); 
          } else if (operation == 3) {
            uf.areFriends(p1, p2);
          } else if (operation == 4) {
            uf.areEnemies(p1, p2);
          }

          line = br.readLine();
        }

      } catch (IOException e) {
        e.printStackTrace();
      }

  }

}