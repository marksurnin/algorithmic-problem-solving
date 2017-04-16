import java.util.*;
import java.lang.*;
import java.io.*;

// Maxflow implementation from
// http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/

class Main
{
	static int V; //Number of vertices in graph
  static int source, sink;
  static int graph[][];
 
	/* Returns true if there is a path from source 's' to sink
	  't' in residual graph. Also fills parent[] to store the
	  path */
	boolean bfs(int rGraph[][], int s, int t, int parent[])
	{
		// Create a visited array and mark all vertices as not
		// visited
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; ++i)
			visited[i]=false;
 
		// Create a queue, enqueue source vertex and mark
		// source vertex as visited
    LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s]=-1;
 
		// Standard BFS Loop
		while (queue.size()!=0)
		{
			int u = queue.poll();
 
			for (int v=0; v<V; v++)
			{
				if (visited[v]==false && rGraph[u][v] > 0)
				{
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}
 
		// If we reached sink in BFS starting from source, then
		// return true, else false
		return (visited[t] == true);
	}
 
	// Returns tne maximum flow from s to t in the given graph
	int fordFulkerson(int graph[][], int s, int t)
	{
		int u, v;
 
		// Create a residual graph and fill the residual graph
		// with given capacities in the original graph as
		// residual capacities in residual graph
 
		// Residual graph where rGraph[i][j] indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is
		// not)
		int rGraph[][] = new int[V][V];
 
		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];
 
		// This array is filled by BFS and to store path
		int parent[] = new int[V];
 
		int max_flow = 0;  // There is no flow initially
 
		// Augment the flow while tere is path from source
		// to sink
		while (bfs(rGraph, s, t, parent))
		{
			// Find minimum residual capacity of the edhes
			// along the path filled by BFS. Or we can say
			// find the maximum flow through the path found.
			int path_flow = Integer.MAX_VALUE;
			for (v=t; v!=s; v=parent[v])
			{
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}
 
			// update residual capacities of the edges and
			// reverse edges along the path
			for (v=t; v != s; v=parent[v])
			{
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}
 
			// Add path flow to overall flow
			max_flow += path_flow;
		}
 
		// Return the overall flow
		return max_flow;
	}
 
	// Driver program to test above functions
	public static void main (String[] args) throws java.lang.Exception
	{
    Scanner sc=new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      V = n*2+2;
      source = 0;
      sink = n*2+1;
      graph = new int[V][V];
      int i, w, m, x, y, b, d;
      for (i = 1; i <= n; i++) {
        w = sc.nextInt();
        graph[i*2-1][i*2] = w;
      }
      m = sc.nextInt();
      for (i = 0; i < m; i++) {
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        graph[x*2][y*2-1] = w;
      }
      b = sc.nextInt();
      d = sc.nextInt();
      for (i = 0; i < b; i++) {
        x = sc.nextInt();
        graph[0][x*2-1] = Integer.MAX_VALUE;
      }
      for (i = 0; i < d; i++) {
        x = sc.nextInt();
        graph[x*2][sink] = Integer.MAX_VALUE;
      }

      Main g = new Main();
 
      System.out.println(g.fordFulkerson(graph, source, sink));
 
    }
	}
}