class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int cost = 0;
        int h = 1, v = 1;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); 

        for (int i : horizontalCut)
            pq.add(new int[] { i, 0 });
        for (int i : verticalCut)
            pq.add(new int[] { i, 1 });

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int s = cur[0];
            int o = cur[1];

            if (o == 0) {
                cost += (s * v);
                h++;
            } else {
                cost += (s * h);
                v++;
            }
        }

        return cost;
    }
}