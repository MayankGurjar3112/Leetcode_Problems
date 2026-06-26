class Solution {
    int[][] visit;

    public int[][] updateMatrix(int[][] mat) {
        visit = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 0)
                    dfs(mat, i, j, 0);
        return mat;
    }

    public void dfs(int[][] mat, int row, int col, int v) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length
                || (visit[row][col] == 1 && mat[row][col] <= v))
            return;
        if (mat[row][col] == 0 && v != 0)
            return;

        mat[row][col] = v;
        visit[row][col] = 1;
        dfs(mat, row, col - 1, v + 1);
        dfs(mat, row, col + 1, v + 1);
        dfs(mat, row - 1, col, v + 1);
        dfs(mat, row + 1, col, v + 1);
    }
}