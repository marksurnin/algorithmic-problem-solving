import java.io.*;
import java.util.*;

public class Main {

  public static void loadCars(int ferryLength, ArrayList<Integer> cars) {
    int left = 0, right = 0;
    for (int i = 0; i < cars.size(); i++) {
      // System.out.printf("%d %d\n", left, right);
      if (left + cars.get(i)/100 <= ferryLength) {
        left += cars.get(i)/100;
        System.out.println("port");
      } else if (right + cars.get(i)/100 <= ferryLength) {
        right += cars.get(i)/100;
        System.out.println("starboard");
      } else {
        System.out.println("overflow");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    ArrayList<Integer> cars = new ArrayList<Integer>();
    boolean last = false;
    int ferryLength = 0;
    br.readLine();
    br.readLine();

    while (!last) {
      String line = br.readLine();
      ferryLength = Integer.parseInt(line);
      line = br.readLine();
      while (!line.equals("0") && !line.equals("")) {
        // System.out.println(Integer.parseInt(line));
        cars.add(Integer.parseInt(line));
        line = br.readLine();
      }
      if (line.equals("0") || line.equals("")) {
        loadCars(ferryLength, cars);
        cars.clear();
        if (line.equals("0")) last = true;
        else System.out.println();
      }
    }
  }
}