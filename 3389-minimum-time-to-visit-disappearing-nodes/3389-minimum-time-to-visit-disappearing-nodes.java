class Solution {
    class Edge {
        int u, v;
        int t;

        public Edge(int u, int v, int t) {
            this.u = u;
            this.v = v;
            this.t = t;
        }

        public String toString() {
            return "(" + u + " " + v + " " + t + ")";
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
        Map<Integer, List<Edge>> map = new HashMap<>();

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());

        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            int t = i[2];

            map.get(u).add(new Edge(u, v, t));
            map.get(v).add(new Edge(v, u, t));
        }

        pq.add(new Edge(0, 0, 0));

        boolean[] visit = new boolean[n];
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur == null)
                break;

            int u = cur.u;
            int v = cur.v;
            int t = cur.t;

            if (visit[v])
                continue;
            visit[v] = true;

            for (Edge i : map.get(v))
                if (result[i.v] > t + i.t && t + i.t < disappear[i.v]) {
                    result[i.v] = t + i.t;
                    i.t += t;
                    pq.add(i);
                }
        }

        for (int i = 0; i < n; i++)
            if (result[i] == Integer.MAX_VALUE)
                result[i] = -1;

        return result;
    }
}