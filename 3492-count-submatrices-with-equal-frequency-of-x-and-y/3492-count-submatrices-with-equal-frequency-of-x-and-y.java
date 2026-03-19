class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] x = new int[m][n];
        int[][] y = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = ((grid[i][j] == 'X') ? 1 : 0);
                y[i][j] = ((grid[i][j] == 'Y') ? 1 : 0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                x[i][j] = x[i][j - 1] + ((grid[i][j] == 'X') ? 1 : 0);
                y[i][j] = y[i][j - 1] + ((grid[i][j] == 'Y') ? 1 : 0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                x[j][i] += x[j - 1][i];
                y[j][i] += y[j - 1][i];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i][j] == y[i][j] && x[i][j] > 0)
                    count++;
            }
        }

        return count;
    }
}