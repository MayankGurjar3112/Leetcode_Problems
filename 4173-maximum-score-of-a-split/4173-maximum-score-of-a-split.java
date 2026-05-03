class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] p = new long[n];
        long[] s = new long[n];
    
        p[0] = nums[0];

        for (int i = 1; i < n; i++) 
            p[i] = nums[i] + p[i - 1];

        long min = nums[n - 1];
        for (int i = n - 1; i > -1; i--) {
            min = Math.min(nums[i], min);
            s[i] = min;
        }

        long max = Long.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) 
            max = Math.max(max, p[i] - s[i + 1]);

        return max;
    }
}