import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String[] line;
    String fields;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine().trim().split("\\s+");
        int numFields = Integer.parseInt(line[0]);

        if (numFields < 100) {
          fields = br.readLine();
          int scarecrows = 0;
          int consecFertile = 0;

          int field = 0;

          while (field < numFields) {
            if (fields.charAt(field) == '.') {
              // System.out.println(".");
              consecFertile++;
            } else {
              // System.out.println("#");
              if (consecFertile == 1) {
                if (fields.length() >= field + 1) {
                  if ((fields.charAt(field) == '#') && (fields.charAt(field + 1) == '.')) {
                    scarecrows += 1;
                    if (fields.length() == field + 2) {
                      break;
                    } else if (fields.length() > field + 2) {
                      // System.out.println(0);
                      field ++;
                    }
                  }
                }
              }

              scarecrows += ((consecFertile / 3) + (consecFertile % 3));
              // System.out.printf("%d %d\n", consecFertile, scarecrows);
              consecFertile = 0;
            }
            field++;
          }
          if (fields.length() > 3) {
            scarecrows += ((consecFertile / 3) + (consecFertile % 3));
          }
          System.out.println(scarecrows);
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}