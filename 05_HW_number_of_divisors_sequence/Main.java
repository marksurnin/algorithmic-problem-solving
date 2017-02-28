import java.io.*;
import java.util.*;

public class Main {

  public static int MAX_VALUE = 1000000;
  public static int[] seq;
  public static int max_index;

  public static int indexOf(int key, boolean isStart) {
    int lo = 0;
    int hi = max_index;
    int mid = 0;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      if (key < seq[mid]) {
        hi = mid - 1;
      } else if (key > seq[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }

    // the above would suffice for a standard binary search
    // however, since we are looking for values that are not
    // necessarily present in the sequence, we have to tweak the code
    if (key < seq[mid]) {
      if (!isStart && lo == hi + 1) {
        return mid - 1;
      }
      if (isStart && lo == hi + 1) {
        return mid;
      }
    } else if (key > seq[mid]) {
      if (!isStart && lo == hi + 1) {
        return mid;
      }
      if (isStart && lo == hi + 1) {
        return mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line;

    try {
      int numTestCases = Integer.parseInt(br.readLine());

      // generate an array with numbers of divisors for each i
      int[] nod = new int[MAX_VALUE + 1];
      for (int factor = 1; factor < MAX_VALUE; factor++) {
        for (int i = factor; i < MAX_VALUE; i += factor) {
          nod[i]++;
        }       
      }

      // generate the sequence
      seq = new int[MAX_VALUE + 1];
      seq[0] = 1;
      for (int i = 1; i <= MAX_VALUE; i++) {
        if (seq[i-1] <= MAX_VALUE) {
          seq[i] = seq[i-1] + nod[seq[i-1]];
        } else {
          max_index = i;
          break;
        }
      }

      for (int i = 0; i < numTestCases; i++) {
        line = br.readLine();
        String[] tokens = line.trim().split("\\s+");
        int start = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);
        int startIndex = indexOf(start, true);
        int endIndex = indexOf(end, false);
        System.out.printf("Case %d: %d\n", i+1, endIndex - startIndex + 1);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}