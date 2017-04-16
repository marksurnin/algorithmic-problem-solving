import java.io.*;
import java.util.*;

public class Main {

  public static int[] lis(int[] arr) {
    int n = arr.length;
    int longest_so_far = 0;
    int[] temp = new int[n + 1];
    Arrays.fill(temp, Integer.MAX_VALUE);
    int[] lis = new int[n + 1];
    for (int i = 0; i < n; i++) {
      int lo = 0;
      int hi = n - 1;
      while (lo < hi) {
        int mid = lo + (hi - lo)/2;
        if (temp[mid] >= arr[i]) {
          hi = mid;
        } else {
          lo = mid;
        }
      }

      if (temp[lo + 1] > arr[i]) {
        temp[lo + 1] = arr[i];
        longest_so_far = Math.max(longest_so_far, lo + 1);
      }
      lis[i] = longest_so_far;
    }
    return lis;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int[] forward = new int[n];
      int[] backward = new int[n];
      for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        forward[i] = x;
        backward[n - i - 1] = x;
      }

      int longest_so_far = 0;
      int[] lis = lis(forward);
      int[] dis = lis(backward);
      for (int i = 0; i < n; i++) {
        if (Math.min(lis[i], dis[n - i - 1]) > longest_so_far) {
          longest_so_far = Math.min(lis[i], dis[n - i - 1]);
        }
      }
      // 2n - 1
      System.out.println(longest_so_far * 2 - 1);
    }
  }
}