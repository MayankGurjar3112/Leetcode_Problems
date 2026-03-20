class Solution {
    int[][] grid;

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k == 1)
            return new int[m][n];
        this.grid = grid;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                result[i][j] = getDiff(i, j, k);
            }
        }

        return result;
    }

    private int getDiff(int i, int j, int k) {
        List<Integer> kgrid = new ArrayList<>();
        for (int x = i; x < i + k; x++) {
            for (int y = j; y < j + k; y++) {
                kgrid.add(grid[x][y]);
            }
        }
        int kmin = Integer.MAX_VALUE;
        Collections.sort(kgrid);
        for (int t = 1; t < kgrid.size(); t++) {
            if (kgrid.get(t).equals(kgrid.get(t - 1))) {
                continue;
            }
            kmin = Math.min(kmin, kgrid.get(t) - kgrid.get(t - 1));
        }
        if (kmin != Integer.MAX_VALUE)
            return kmin;
        return 0;
    }
}