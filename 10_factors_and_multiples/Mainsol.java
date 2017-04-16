import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Mainsol {
    public static int bfs(int s, int t, int[][] res, int[] parent) {
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(s);
        Q.add(Integer.MAX_VALUE);
        while (!Q.isEmpty()) {
            int n = Q.poll();
            int flow = Q.poll();
            if (n == t)
                return flow;
            for (int j = 0; j < res[n].length; j++) {
                if (res[n][j] != 0 && parent[j] == -1) {
                    Q.add(j);
                    Q.add(Math.min(flow, res[n][j]));
                    parent[j] = n;
                }
            }
        }
        return 0;
    }
 
    public static void augmentPath(int s, int t, int flow, int[] parent,
            int[][] res) {
        int cur = t;
        while (cur != s) {
            res[parent[cur]][cur] -= flow;
            res[cur][parent[cur]] += flow;
            cur = parent[cur];
        }
    }
 
    public static int maxFlow(int s, int t, int[][] res) {
        int[] parent = new int[res.length];
        Arrays.fill(parent, -1);
        int flow, maxflow = 0;
        while ((flow = bfs(s, t, res, parent)) != 0) {
            maxflow += flow;
            augmentPath(s, t, flow, parent, res);
            Arrays.fill(parent, -1);
        }
        return maxflow;
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        int cc = 1;
        while (tc-- > 0) {
            int n = in.nextInt();
            System.out.println(n);
            LinkedList<Integer> cache = new LinkedList<Integer>();
            for (int i = 0; i < n; i++)
                cache.add(in.nextInt());
            System.out.println(cache.get(0));
            int m = in.nextInt();
            int[] g = new int[m + n + 2];
            int top = 1;
            for (int i : cache) {
                g[top++] = i;
            }
            for (int i = 0; i < m; i++)
                g[top++] = in.nextInt();
            int[][] res = new int[m + n + 2][m + n + 2];
            for (int i = 1; i <= n; i++)
                res[0][i] = 1;
            for (int i = n + 1; i <= m + n; i++)
                res[i][m + n + 1] = 1;
            for (int i = 1; i <= n; i++)
                for (int j = n + 1; j <= m + n; j++)
                    if ((g[i] != 0 && g[j] % g[i] == 0)
                            || (g[i] == 0 && g[j] == 0))
                        res[i][j] = 1;
            System.out
                    .printf("Case %d: %d\n", cc++, maxFlow(0, m + n + 1, res));
        }
    }
}