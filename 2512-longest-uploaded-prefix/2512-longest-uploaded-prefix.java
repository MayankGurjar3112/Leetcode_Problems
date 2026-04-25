class LUPrefix {
    Queue<Integer> pq1;
    Queue<Integer> pq2;

    public LUPrefix(int n) {
        pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        pq2 = new PriorityQueue<>();
        pq1.add(0);
        pq2.add(Integer.MAX_VALUE);
    }

    public void upload(int video) {
        pq2.add(video);
    }

    public int longest() {
        int t1 = pq1.peek();
        int t2 = pq2.peek();
        while (t1 + 1 == t2) {
            pq1.add(pq2.remove());
            t1 = t2;
            t2 = pq2.peek();
        }
        return pq1.peek();
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */