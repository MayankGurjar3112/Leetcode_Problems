class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) 
            list.add(new ArrayList<>());
        
        for (int[] i : times) 
            list.get(i[0]).add(new int[] { i[1], i[2] });

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.add(new int[] {0, k});

        while (!pq.isEmpty()) {
            int d = pq.peek()[0];
            int node = pq.peek()[1];

            pq.remove();

            for (int[] i : list.get(node)) {
                int nDist = d + i[1];
                if (nDist < dist[i[0]]) {
                    dist[i[0]] = nDist;
                    pq.add(new int[] { nDist, i[0] });
                }
            }
        }

        dist[0] = 0;
        int max = 0;

        for (int i : dist) 
            if (i != Integer.MAX_VALUE)
                max = Math.max(max, i);
            else 
                return -1;

        return max;
    }
}