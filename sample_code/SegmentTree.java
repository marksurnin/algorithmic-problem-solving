import java.util.*;

//min queries
public class SegmentTree {
  public ArrayList<Integer> list;
  public int[] st;

  public SegmentTree(ArrayList<Integer> list) {
    this.list = list;
    this.st = new int[4 * list.size()];
    build(0, list.size() - 1, 0);
  }

  // Initialize: build(0, list.size() - 1, 0);
  public void build(int nL, int nR, int n) {
    if (nL == nR)
      st[n] = nL;
    else {
      int mid = (nL + nR) / 2, l = left(n), r = right(n);
      build(nL, mid, l);
      build(mid + 1, nR, r);
      st[n] = list.get(st[l]) <= list.get(st[r]) ? st[l] : st[r];
    }
  }

  // Index of left child
  int left(int n) {
    return 2 * n + 1;
  }

  // Index of right child
  int right(int n) {
    return left(n) + 1;
  }

  public void update(int pos, int value) {
    update(pos, value, 0, list.size() - 1, 0);
  }

  // Update segment tree at given position with given value.
  // Current node n has index range [nL,nR]
  public void update(int pos, int value, int nL, int nR, int n) {
    if (nL == nR) {
      list.set(pos, value);
      st[n] = pos;
    } else {
      int mid = (nL + nR) / 2, l = left(n), r = right(n);
      if (pos <= mid)
        update(pos, value, nL, mid, l);
      else
        update(pos, value, mid + 1, nR, r);
      st[n] = list.get(st[l]) <= list.get(st[r]) ? st[l] : st[r];
    }
  }

  public int minQuery(int L, int R) {
    return minQuery(L, R, 0, list.size() - 1, 1);
  }

  // Get index of minimum value in index range [L,R]
  // Current node n has index range [nL,nR]
  public int minQuery(int L, int R, int nL, int nR, int n) {
    if (L <= nL && nR <= R)
      return st[n];
    int lMin = -1, rMin = -1;
    int mid = (nL + nR) / 2;
    if (L <= mid)
      lMin = minQuery(L, R, nL, mid, left(n));
    if (mid + 1 <= R)
      rMin = minQuery(L, R, mid + 1, nR, right(n));
    if (lMin == -1 || rMin == -1)
      return lMin == -1 ? rMin : lMin;
    return list.get(lMin) <= list.get(rMin) ? lMin : rMin;
  }

  public static void main(String[] args) {
    Random r = new Random(1);
    int N = Integer.parseInt(args[0]);
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < N; ++i)
      list.add(r.nextInt());
    SegmentTree st = new SegmentTree(list);
    for (int i = 0; i < 100; ++i) {
      for (int a = 0; a < N; ++a)
        for (int b = a; b < N; ++b) {
          int min = Integer.MAX_VALUE;
          for (int x = a; x <= b; ++x)
            min = Math.min(min, list.get(x));
          int val = list.get(st.minQuery(a, b));
          if (min != val)
            System.out.printf("BAD [%d,%d]: correct=%d vs %d\n", a,
                b, min, val);
        }
      int p = r.nextInt(N), v = r.nextInt();
      st.update(p, v);
      if (list.get(p) != v)
        System.out.println("UPDATE FAILED!");
    }
  }
}