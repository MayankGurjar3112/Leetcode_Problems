class MedianFinder {
    Queue<Double> p = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    Queue<Double> q = new PriorityQueue<>();

    public void addNum(int num) {
        p.add(num / 1.0);
        while (p.size() >= q.size() + 2)
            q.add(p.remove());
        while ((!p.isEmpty() && !q.isEmpty()) && p.peek() > q.peek()) {
            Double t = p.remove();
            p.add(q.remove());
            q.add(t);
        }
    }

    public double findMedian() {
        if ((p.size() + q.size()) % 2 == 0) {
            return (p.peek() + q.peek()) / 2.0;
        } else {
            return p.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */