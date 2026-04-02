class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int n = piles.length;

        int i = 0, j = n;

        int sum = 0;
        while (i < j) {
            i++;
            j -= 2;
            sum += piles[j];
        }

        return sum;
    }
}