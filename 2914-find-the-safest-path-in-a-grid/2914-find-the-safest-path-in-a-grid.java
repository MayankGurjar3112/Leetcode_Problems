class Solution {
    int[][] g;
    int n;
    List<List<Integer>> grid;
    final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        g = new int[n][n];
        this.grid = grid;

        for (int[] i : g)
            Arrays.fill(i, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid.get(i).get(j) == 1) {
                    g[i][j] = 0;
                    q.add(new int[] { i, j, i, j });
                }
        bfs(q);

        int low = 0, high = 0, prev = 0;

        for (int[] i : g)
            for (int j : i)
                high = Math.max(high, j);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findPath(0, 0, mid, new boolean[n][n])) {
                low = mid + 1;
                prev = mid;
            } else
                high = mid - 1;
        }

        return prev;
    }

    private void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] d : dir) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    int i = cur[2];
                    int j = cur[3];
                    int val = g[cur[0]][cur[1]];

                    if (isValidCell(g, x, y) && g[x][y] == Integer.MAX_VALUE) {
                        g[x][y] = Math.min(g[x][y], Math.abs(x - i) + Math.abs(y - j));
                        q.add(new int[] { x, y, i, j });
                    }
                }
            }
        }
    }

    private boolean isValidCell(int[][] mat, int i, int j) {
        int n = mat.length;
        return i >= 0 && j >= 0 && i < n && j < n;
    }

    private boolean findPath(int x, int y, int min, boolean[][] visit) {
        if (x < 0 || x >= n || y < 0 || y >= n || visit[x][y] || g[x][y] < min)
            return false;
        if (x == n - 1 && y == n - 1)
            return true;

        visit[x][y] = true;

        return findPath(x - 1, y, min, visit) || findPath(x + 1, y, min, visit) || findPath(x, y - 1, min, visit)
                || findPath(x, y + 1, min, visit);
    }
}