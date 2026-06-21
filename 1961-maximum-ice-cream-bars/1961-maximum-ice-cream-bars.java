class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;

        for (int cost : costs) 
            max = Math.max(max, cost);

        int[] freq = new int[max + 1];

        for (int cost : costs) 
            freq[cost]++;

        int ans = 0;

        for (int price = 1; price <= max; price++) {
            if (freq[price] == 0) 
                continue;

            int canBuy = Math.min(freq[price], coins / price);
            ans += canBuy;
            coins -= canBuy * price;

            if (coins < price) 
                break;
        }

        return ans;
    }
}