import java.io.*;
import java.util.*;

public class Main {

  public static void lis(ArrayList<Integer> seq) {
    final int MAX_N = 100000;

    // convert ArrayList to int array
    int n = seq.size();
    int[] A = new int[n];
    Iterator<Integer> it = seq.iterator();
    int c = 0;
    while (it.hasNext()) {
      A[c] = it.next();
      c++;
    }

    int[] L_id = new int[MAX_N], P = new int[MAX_N];
    Vector<Integer> L = new Vector<Integer>();

    int lis = 0, lis_end = 0;
    for (int i = 0; i < n; ++i) {
      int pos = Collections.binarySearch(L, A[i]);
      if (pos < 0) {
        pos = -(pos + 1);
      }
      if (pos >= L.size()) {
        L.add(A[i]);
      }
      else {
        L.set(pos, A[i]);
      }
      L_id[pos] = i;
      P[i] = pos > 0 ? L_id[pos - 1] : -1;
      if (pos + 1 > lis) {
        lis = pos + 1;
        lis_end = i;
      }
    }

    // remove values < 1
    ArrayList<Integer> output = new ArrayList<Integer>();
    for (int i = 0; i < L.size(); i++) {
      if (L.get(i) > 0) {
        output.add(L.get(i));
      }
    }

    System.out.printf("Max hits: %d\n", output.size());
    it = output.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    ArrayList<Integer> seq = new ArrayList<Integer>();
    int tests = Integer.parseInt(br.readLine());
    br.readLine();

    while (tests > 0) {
      String line = br.readLine();
      while (line != null && (line.length() != 0)) {
        // System.out.println(line);
        seq.add(Integer.parseInt(line));
        line = br.readLine();
      }
      lis(seq);
      seq.clear();
      tests--;
      if (line == null || tests == 0) {
        break;
      } else {
        System.out.println();
      }
    }
  }
}