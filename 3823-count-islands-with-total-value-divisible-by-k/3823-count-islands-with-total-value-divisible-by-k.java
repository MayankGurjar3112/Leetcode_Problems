class Solution {
    int[][] grid;
    int m, n;

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        this.grid = grid;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != 0 && dfs(i, j) % k == 0)
                    count++;

        return count;
    }

    private long dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;

        long val = grid[i][j];
        grid[i][j] = 0;

        return dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1) + val;
    }
}