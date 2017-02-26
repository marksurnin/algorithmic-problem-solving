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
        int nDragons = Integer.parseInt(tokens[0]);
        int nKnights = Integer.parseInt(tokens[1]);

        if (nDragons + nKnights == 0) {
          break;
        }

        int[] dragons = new int[nDragons];
        int[] knights = new int[nKnights];

        for (int i = 0; i < nDragons; i++) {
          line = br.readLine();
          dragons[i] = Integer.parseInt(line);
        }
        
        for (int i = 0; i < nKnights; i++) {
          line = br.readLine();
          knights[i] = Integer.parseInt(line);
        }

        Arrays.sort(dragons);
        Arrays.sort(knights);

        int sum = 0;
        int dragon = 0;
        
        if (dragons.length > 0) {
          for (int i = 0; i < nKnights; i++) {
            if (knights[i] >= dragons[dragon]) {
              sum += knights[i];
              dragon++;
              if (dragon == dragons.length) {
                break;
              }
            }
          }
        }

        //System.out.println();
        //System.out.printf("%d %d\n", dragon, dragons.length);
        if (dragon < dragons.length) {
          System.out.println("Loowater is doomed!");
        } else {
          System.out.println(sum);
        }
        
        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}