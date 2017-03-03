import java.io.*;
import java.util.*;

public class Jaccard {

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;
    Map<String, Integer> hm = new HashMap();

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine();
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        for (String s : tokens) {
          if (hm.containsKey(s)) {
            hm.put(s, hm.get(s) + 1);
          } else {
            hm.put(s, 1);
          }
        }
        line = br.readLine();
        tokens = line.trim().split("\\s+");
        for (String s : tokens) {
          if (hm.containsKey(s)) {
            hm.put(s, hm.get(s) + 1);
          } else {
            hm.put(s, 1);
          }
        }

        float intersection = 0;
        float union = 0;
        for (String key : hm.keySet()) {
          // System.out.printf("%s %d\n", key, hm.get(key));
          union++;
          if (hm.get(key) == 2) {
            intersection++;
          }
        }
        hm.clear();
        System.out.println(intersection/union);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}