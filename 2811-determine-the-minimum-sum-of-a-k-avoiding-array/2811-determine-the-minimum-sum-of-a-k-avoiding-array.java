class Solution {
    public int minimumSum(int n, int target) {
        int k = target / 2;
        if (n <= k)
            return 1 * n * (n + 1) / 2;
        return k * (k + 1) / 2 + (target + target + n - k - 1) * (n - k) / 2;
    }
}