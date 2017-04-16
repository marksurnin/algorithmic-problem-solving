import java.io.*;
import java.util.*;

public class Main {
  public static boolean[][] reachable;
  public static Integer[][] array = new Integer[2001][10001];

  public static void recurse(int current, int length) {
    if (current == 0) return;
    recurse(current - 1, array[current][length]);
    if (array[current][length] == length) {
      System.out.println("port");
    } else {
      System.out.println("starboard");
    }
  }

  public static void loadCars(int ferryLength, ArrayList<Integer> cars) {
    // DP uses 1-based indexing
    reachable = new boolean[2001][10001];
    reachable[0][0] = true;
    int sum = 0, car = 0, res = 0, length = 0;
    for (int i = 1; i <= cars.size(); i++) {
      car = cars.get(i-1);
      sum += car;
      System.out.printf("%d\n", sum);
      for (int j = 0; j < cars.size(); j++) {
        // System.out.printf("%d %d %d %d\n", sum, i, j, ferryLength);
        if (sum - j <= ferryLength && reachable[i-1][j]) {
          reachable[i][j] = true;
          array[i][j] = j;
          res = i;
          length = j;
        } else if (j >= car && reachable[i - 1][j - car]) {
          reachable[i][j] = true;
          array[i][j] = j - car;
          res = i;
          length = j;
        }
        System.out.printf("%d %d\n", res, length);
      }
    }
    recurse(res, length);
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
      ferryLength = Integer.parseInt(line) * 100;
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