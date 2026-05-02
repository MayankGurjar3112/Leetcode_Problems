class Solution {

    class UF {
        int[] p;
        int[] r;

        public UF(int n) {
            p = new int[n];
            r = new int[n];

            for (int i = 0; i < n; i++)
                p[i] = i;
        }

        public int find(int u) {
            if (p[u] == u)
                return u;
            return p[u] = find(p[u]);
        }

        public boolean union(int u, int v) {
            int a = find(u);
            int b = find(v);

            if (a == b)
                return false;

            if (r[a] == r[b]) {
                r[a]++;
                p[b] = a;
            } else if (r[a] > r[b])
                p[b] = a;
            else 
                p[a] = b;

            return true;
        }
    }

    class Edge {
        int d, x, y;

        public Edge(int d, int x, int y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.d, b.d));
        UF mst = new UF(points.length);
        int cost = 0;

        for (int i = 0; i < points.length; i++) 
            for (int j = i + 1; j < points.length; j++) 
                pq.add(new Edge(manDistance(points[i], points[j]), i, j));
            
        while (!pq.isEmpty()) {
            Edge cur = pq.remove();
            if (mst.union(cur.x, cur.y))
                cost += cur.d;
        }

        return cost;
    }

    private int manDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}