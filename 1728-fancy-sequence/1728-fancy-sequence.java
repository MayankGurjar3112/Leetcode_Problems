class Fancy {
    static final int MOD = 1000000007;
    List<Integer> m;
    List<Integer> a;
    List<Integer> l;

    public Fancy() {
        m = new ArrayList<>();
        a = new ArrayList<>();
        l = new ArrayList<>();
        m.add(1);
        a.add(0);
    }
    
    public void append(int val) {
        l.add(val);
        m.add(m.get(m.size() - 1));
        a.add(a.get(a.size() - 1));
    }
    
    public void addAll(int inc) {
        a.set(a.size() - 1, (a.get(a.size() - 1) + inc) % MOD);
    }
    
    public void multAll(int mul) {
        int i = m.size() - 1, j = a.size() - 1;
        m.set(i, (int) (((long) m.get(i) * mul) % MOD));
        a.set(i, (int) (((long) a.get(j) * mul) % MOD));
    }
    
    public int getIndex(int idx) {
        if (idx >= l.size()) return -1;
        int mul = (int) (((long) inv(m.get(idx)) * m.get(m.size() - 1)) % MOD);
        int add = (int) (((long) a.get(a.size() - 1) - ((long) a.get(idx) * mul) % MOD + MOD) % MOD);
        int ans = (int) (((((long) mul * l.get(idx)) % MOD) + add) % MOD);
        return ans;
    }

    private int quickmul(int x, int y) {
        long ret = 1;
        long cur = x;
        while (y != 0) {
            if ((y & 1) != 0) {
                ret = (ret * cur) % MOD;
            }
            cur = (cur * cur) % MOD;
            y >>= 1;
        }
        return (int) ret;
    }

    // multiplicative inverse
    private int inv(int x) {
        return quickmul(x, MOD - 2);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */