class Solution {
    char[][] board;
    int m, n;

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;

        this.board = board;

        int count = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'X') {
                    dfs(i, j);
                    count++;
                }

        return count;
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '.')
            return false;

        board[i][j] = '.';

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);

        return true;
    }
}