class Solution {
    Queue<Integer> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    Queue<Integer> pq2 = new PriorityQueue<>();

    public int numTimesAllBlue(int[] flips) {
        pq1.add(0);
        int count = 0;

        for (int i : flips) {
            pq2.add(i);
            balance();
            if (pq2.isEmpty())
                count++;
        }

        return count;
    }

    private void balance() {
        Integer t1 = pq1.peek();
        Integer t2 = pq2.peek();
        
        while (!pq2.isEmpty() && t1 + 1 == t2) {
            pq1.add(pq2.remove());
            t1 = t2;
            t2 = pq2.peek();
        }
    }
}