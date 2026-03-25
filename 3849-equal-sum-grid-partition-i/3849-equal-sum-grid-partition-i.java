class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] p1 = new long[m];
        long[] s1 = new long[m];
        long[] p2 = new long[n];
        long[] s2 = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                p1[i] += grid[i][j];
            s1[i] = p1[i];
        }
        for (int i = 1; i < m; i++)
            p1[i] += p1[i - 1];
        for (int i = m - 2; i > -1; i--)
            s1[i] += s1[i + 1];
        for (int i = 0; i < m - 1; i++)
            if (p1[i] == s1[i + 1])
                return true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                p2[i] += grid[j][i];
            s2[i] = p2[i];
        }
        for (int i = 1; i < n; i++)
            p2[i] += p2[i - 1];
        for (int i = n - 2; i > -1; i--)
            s2[i] += s2[i + 1];
        for (int i = 0; i < n - 1; i++)
            if (p2[i] == s2[i + 1])
                return true;

        return false;
    }
}