class SmallestInfiniteSet {
    Queue<Integer> pq = new PriorityQueue<>();
    int n = 1;

    public SmallestInfiniteSet() {}
    
    public int popSmallest() {
        if (pq.isEmpty() || n < pq.peek()) return n++;
        else if (pq.peek() < n) {
            int n = pq.remove();
            while (!pq.isEmpty() && n == pq.peek()) n = pq.remove();
            return n;
        }
        n++;
        int n = pq.remove();
        while (!pq.isEmpty() && n == pq.peek()) n = pq.remove();
        return n;
    }
    
    public void addBack(int num) {
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */