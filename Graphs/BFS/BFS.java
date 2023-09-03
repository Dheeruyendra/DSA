package Graphs.BFS;
import java.util.*;
public class BFS {
//TC => O(V+E)
    static int[] solve(List<List<Integer>> adj, int src) {
        int v = adj.size();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        boolean[] visited = new boolean[v + 1];
        visited[src] = true;

        int[] parent = new int[v + 1];
        Arrays.fill(parent, -1);

        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neigh = adj.get(node);

            for (int next : neigh) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = node;
                }
            }
        }

        return parent;
    }

    static void reconstructPath(int[] prev, int s, int e) {
        List<Integer> path = new ArrayList<>();
        for (int at = e; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        if (path.get(0) == s) {
            print(path);
        }
    }

    static void print(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }

    static void bfs(List<List<Integer>> adj, int s, int e) {
        int[] prev = solve(adj, s);
        reconstructPath(prev, s, e);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        int src = in.nextInt();
        int end = in.nextInt();

        //Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        //adding edges
        for (int i = 0; i < e; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        in.close();
        bfs(adj, src, end);
    }
}