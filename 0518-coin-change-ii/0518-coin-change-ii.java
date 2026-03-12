class Solution {
    int[] coins;
    int n;
    int[][] memo;

    public int change(int amount, int[] coins) {
        n = coins.length;
        this.coins = coins;
        memo = new int[n][amount + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        return dp(n - 1, amount);
    }

    private int dp(int i, int amount) {
        if (i == 0)
            return amount % coins[0] == 0 ? 1 : 0;
        if (memo[i][amount] != -1)
            return memo[i][amount];

        int notTake = dp(i - 1, amount);
        int take = 0;
        if (coins[i] <= amount)
            take = dp(i, amount - coins[i]);

        return memo[i][amount] = notTake + take;
    }
}