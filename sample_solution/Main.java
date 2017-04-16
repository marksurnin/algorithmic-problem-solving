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
        line = br.readLine();
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        
        System.out.println();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}