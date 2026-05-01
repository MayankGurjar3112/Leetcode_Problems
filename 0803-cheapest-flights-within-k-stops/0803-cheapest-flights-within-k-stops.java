class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int j = 0; j <= k; j++) {
            int[] temp = dist.clone();
            for (int[] i : flights) {
                int u = i[0];
                int v = i[1];
                int c = i[2];

                if (dist[u] == Integer.MAX_VALUE)
                    continue;

                temp[v] = Math.min(temp[v], dist[u] + c);
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}