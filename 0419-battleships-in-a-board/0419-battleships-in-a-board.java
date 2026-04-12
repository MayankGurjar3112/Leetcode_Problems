class Solution {
    char[][] board;
    boolean[][] visit;
    int m, n;

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;

        visit = new boolean[m][n];
        this.board = board;

        int count = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visit[i][j] && dfs(i, j))
                    count++;

        return count;
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visit[i][j] || board[i][j] == '.')
            return false;

        visit[i][j] = true;

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);

        return true;
    }
}