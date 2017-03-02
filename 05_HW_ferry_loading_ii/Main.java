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
        String[] tokens = line.trim().split("\\s+");
        int capacity = Integer.parseInt(tokens[0]);
        int tripTime = Integer.parseInt(tokens[1]);
        int numCars = Integer.parseInt(tokens[2]);
        // total time elapsed
        int time = 0;
        int trips = 0;
        int carsOnFerry = 0;
        int[] times = new int[numCars];
        boolean first = (numCars % capacity) != 0;

        // generate the times array
        for (int j = 0; j < numCars; j++) {
          times[j] = Integer.parseInt(br.readLine());
        }

        // start processing it
        for (int j = 0; j < numCars; j++) {
          if (time < times[j]) {
            time = times[j];
          }
          carsOnFerry++;
          if (first && (carsOnFerry == numCars % capacity)) {
              first = false;
              time += tripTime * 2;
              carsOnFerry = 0;
              trips++;
          } else if (!first && (carsOnFerry == capacity)) {
            time += tripTime * 2;
            carsOnFerry = 0;
            trips++;
          }
        }

        System.out.printf("%d %d\n", time - tripTime, trips);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}