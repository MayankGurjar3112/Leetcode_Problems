class Solution {
    int[] coins;
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];

        Arrays.fill(memo, -2);

        return dp(amount);
    }

    private int dp(int rem) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (memo[rem] != -2) return memo[rem];

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dp(rem - coin);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }

        memo[rem] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return memo[rem];
    }
}