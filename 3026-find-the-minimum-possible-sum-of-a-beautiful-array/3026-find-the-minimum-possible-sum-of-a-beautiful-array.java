class Solution {
    public int minimumPossibleSum(int n, int target) {
        return (int) (minimumPossibleSum(n + 0L, target + 0L) % 1000000007);
    }

    public long minimumPossibleSum(long n, long target) {
        long k = target / 2;
        if (n <= k)
            return 1L * n * (n + 1) / 2;
        return k * (k + 1) / 2 + (target + target + n - k - 1) * (n - k) / 2;
    }
}