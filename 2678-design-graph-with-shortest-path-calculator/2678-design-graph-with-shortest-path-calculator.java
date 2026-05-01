class Graph {
    class Node {
        int u;
        int d;

        public Node(int u, int d) {
            this.u = u;
            this.d = d;
        }

        public String toString() {
            return "(" + u + ", " + d + ")";
        }
    }

    int n;
    List<List<Node>> adj;
    Queue<Node> pq;
    int[] dist;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++)
            addEdge(edges[i]);

    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int d = edge[2];

        List<Node> uList = adj.get(u);

        uList.add(new Node(v, d));
    }

    public int shortestPath(int node1, int node2) {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a.d, b.d));
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        pq.add(new Node(node1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            int d = cur.d;
            int u = cur.u;

            if (u == node2)
                break;

            List<Node> uList = adj.get(u);
            for (Node i : uList) {
                if (dist[i.u] > d + i.d) {
                    dist[i.u] = d + i.d;
                    pq.add(new Node(i.u, dist[i.u]));
                }
            }
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */