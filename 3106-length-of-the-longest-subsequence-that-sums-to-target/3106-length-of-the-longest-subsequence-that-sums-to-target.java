class Solution {
    List<Integer> nums;
    int n;
    int[][] memo;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        this.nums = nums;
        n = nums.size();
        memo = new int[n][target + 1];

        for (int[] i : memo) Arrays.fill(i, -1);

        int ans = dfs(0, target);

        return ans > 0 ? ans : -1;     
    }

    private int dfs(int i, int t) {
        if (t == 0) return 0;
        if (t < 0 || i >= n) return -10000;
        if (memo[i][t] != -1) return memo[i][t];

        int skip = dfs(i + 1, t);
        int take = dfs(i + 1, t - nums.get(i)) + 1;

        return memo[i][t] = Math.max(skip, take);
    }
}