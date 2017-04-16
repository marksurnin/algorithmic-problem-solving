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
        int length = Integer.parseInt(tokens[0]);
        int numStations = Integer.parseInt(tokens[1]);

        // end of input ("0 0")
        if (length + numStations == 0) {
          break;
        }

        int[][] stations = new int[numStations][2];

        for (int i = 0; i < numStations; i++) {
          line = br.readLine();
          tokens = line.trim().split("\\s+");
          int loc = Integer.parseInt(tokens[0]);
          int radius = Integer.parseInt(tokens[1]);
          int[] station = {loc - radius, loc + radius};
          stations[i] = station;
        }

        // sort `stations` by increasing left point
        Arrays.sort(stations, new Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
            int result = Integer.compare(a[0], b[0]);
            // if there is a tie, sort by decreasing right point
            if (result == 0) {
              result =  Integer.compare(b[1], a[1]);
            }
            return result;
          }
        });

        int i = 0;
        int temp = 0;
        int position = 0;
        int minNum = numStations;

        while (position < length) {
          temp = position;

          while (i < numStations && stations[i][0] <= position) {
            temp = Math.max(temp, stations[i++][1]);
          }

          if (temp == position) break;
          position = temp;
          minNum--;
        }

        System.out.printf("%d\n", position < length ? -1 : minNum);

        line = br.readLine();
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}