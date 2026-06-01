class Solution {
    public int minimumCost(int[] cost) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : cost)
            pq.add(i);
        int c = 0;
        while (!pq.isEmpty()) {
            Integer a = pq.poll();
            Integer b = pq.poll();
            pq.poll();
            c += a + (b == null ? 0 : b);
        }
        return c;
    }
}