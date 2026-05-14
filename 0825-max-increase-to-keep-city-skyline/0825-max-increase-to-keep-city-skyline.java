class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] r = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i] = Math.max(r[i], grid[i][j]);
                c[i] = Math.max(c[i], grid[j][i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum += Math.min(r[i], c[j]) - grid[i][j];

        return sum;
    }
}