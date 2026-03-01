class StockSpanner {
    List<Integer> s = new ArrayList<>();
    int n = 0;

    public StockSpanner() {
        s.add(Integer.MAX_VALUE);
    }
    
    public int next(int price) {
        int top = s.get(n++);
        if (top > price) {
            s.add(price);
            return 1;
        } else {
            int count = 1;
            int i = n - 1;
            while (i > -1) {
                if (s.get(i--) <= price) count++;
                else break;
            }
            s.add(price);
            return count;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */