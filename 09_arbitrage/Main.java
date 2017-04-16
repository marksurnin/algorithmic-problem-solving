import java.io.*;
import java.util.*;

public class Main {

  public static void floydWarshall(float[][][] rates, int[][][] routes) {
    int n = rates.length;
    float max;
    boolean found = false;

    for (int length = 1; length < n; length++) {
      for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            float temp = rates[length - 1][i][k] * rates[0][k][j];
            if (temp > rates[length][i][j]) {
              rates[length][i][j] = temp;
              routes[length][i][j] = k;
            }
          }
        }
      }
    }

    int index = -1;
    int resLength = -1;
    for (int length = 1; length < n; length++) {
      for (int i = 0; i < n; i++) {
        if (rates[length][i][i] > 1.01) {
          index = i;
          resLength = length;
          break;
        }
      }
      if (index != -1) {
        break;
      }
    }

    if (index == -1) {
      System.out.println("no arbitrage sequence exists");
    } else {
      ArrayList<Integer> path = new ArrayList<Integer>();
      path.add(index);
      int current = index;
      for (int length = resLength; length >= 0; length--) {
        current = routes[length][index][current];
        path.add(current);
      }

      System.out.print(path.get(path.size() - 1) + 1);
      for (int i = path.size() - 2; i >= 0; i--) {
        System.out.printf(" %d", path.get(i) + 1);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      float[][][] rates = new float[n][n][n+1];
      int[][][] routes = new int[n][n][n+1];

      for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
          for (int z = 0; z < n; z++) {
            routes[x][y][x] = -1;
          }
        }
      }

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
          if (row == col) {
            rates[0][row][col] = (float) 1.0;
          } else {
            rates[0][row][col] = sc.nextFloat();
          }
          routes[0][row][col] = row;
        }
      }
      
      floydWarshall(rates, routes);

      // for (int row = 0; row < n; row++) {
      //   for (int col = 0; col < n; col++) {
      //     System.out.printf("%f ", rates[row][col][0]);
      //   }
      //   System.out.println();
      // }
    }
  }
}