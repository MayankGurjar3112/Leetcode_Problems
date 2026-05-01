class Solution {
    class Node {
        int u;
        double p;

        public Node(int u, double p) {
            this.u = u;
            this.p = p;
        }

        public String toString() {
            return "(" + u + ", " + p + ")";
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adj = new ArrayList<>();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.p, a.p));
        double[] dist = new double[n];

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            List<Node> uList = adj.get(u);
            List<Node> vList = adj.get(v);

            uList.add(new Node(v, p));
            vList.add(new Node(u, p));
        }

        Arrays.fill(dist, Double.MIN_VALUE);
        dist[start_node] = 0;

        pq.add(new Node(start_node, 1));

        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            double p = cur.p;
            int u = cur.u;

            if (u == end_node)
                break;

            List<Node> uList = adj.get(u);

            for (Node i : uList) {
                if (dist[i.u] < p * i.p) {
                    dist[i.u] = p * i.p;
                    pq.add(new Node(i.u, dist[i.u]));
                }
            }
        }

        return dist[end_node];
    }
}