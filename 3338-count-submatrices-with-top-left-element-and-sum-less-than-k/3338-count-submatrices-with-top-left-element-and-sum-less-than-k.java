class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += grid[i][j - 1];

        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                grid[j][i] += grid[j - 1][i];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] <= k)
                    count++;

        return count;
    }
}