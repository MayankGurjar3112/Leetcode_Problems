class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0L;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i : nums)
            pq.add(i);

        while (k > 0) {
            double cur = pq.remove();
            score += cur;
            pq.add((int) Math.ceil(cur / 3));
            k--;
        }

        return score;
    }
}