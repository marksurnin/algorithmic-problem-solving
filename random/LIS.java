import java.io.*;
import java.util.*;

public class LIS {
  public static int max_lis_length;

  public static int _lis(int[] arr, int n) {
    if (n == 1) {
      return 1;
    }

    int current_lis_length = 1;
    for (int i = 0; i < n - 1; i++) {
      int subproblem_lis_length = _lis(arr, i);
      if (arr[i] < arr[n-1] && current_lis_length < subproblem_lis_length+1) {
        current_lis_length = subproblem_lis_length+1;
      }
    }
    if (max_lis_length < current_lis_length) {
      max_lis_length = current_lis_length;
    }
    return current_lis_length;
  }

  public static int lis(int[] arr, int n) {
    max_lis_length = 1;
    _lis(arr, n);
    return max_lis_length;
  }

  public static void main(String[] args) {
    int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    int n = arr.length;
    System.out.println(lis(arr, n));
  }
}