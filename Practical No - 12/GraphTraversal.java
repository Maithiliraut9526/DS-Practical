import java.util.*;

public class GraphTraversal{
    int V;                 // number of vertices
    List<Integer>[] adj;   // adjacency list

    // Constructor
    GraphTraversal(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // BFS Traversal
    void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int neigh : adj[node]) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        System.out.println();
    }

    // DFS Traversal (recursive)
    void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neigh : adj[node]) {
            if (!visited[neigh]) {
                dfsHelper(neigh, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        GraphTraversal g = new GraphTraversal(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u, w);
        }

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        g.bfs(start);
        g.dfs(start);

        sc.close();
    }
}
