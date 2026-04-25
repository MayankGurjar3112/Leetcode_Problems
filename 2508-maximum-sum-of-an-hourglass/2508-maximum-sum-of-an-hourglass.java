class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += grid[i][j - 1];

        for (int i = 0; i < m - 2; i++) {
            for (int j = 2; j < n; j++) {
                int sum = 0;
                sum += grid[i][j] - (j - 3 > -1 ? grid[i][j - 3] : 0);
                sum += grid[i + 1][j - 1] - grid[i + 1][j - 2];
                sum += grid[i + 2][j] - (j - 3 > -1 ? grid[i + 2][j - 3] : 0);
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}