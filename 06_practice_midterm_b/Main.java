import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      line = br.readLine();

      while (line != null && line.length() != 0) {
        String[] tokens = line.trim().split("\\s+");

        System.out.println(0);
        
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}