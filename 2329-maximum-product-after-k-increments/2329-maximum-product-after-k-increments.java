class Solution {
    public int maximumProduct(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i : nums)
            pq.add(i);

        for (int i = 0; i < k; i++)
            pq.add(pq.remove() + 1);

        long prod = 1;

        while (!pq.isEmpty()) {
            prod *= pq.remove();
            prod %= 1000000007L;
        }

        return (int) prod;
    }
}