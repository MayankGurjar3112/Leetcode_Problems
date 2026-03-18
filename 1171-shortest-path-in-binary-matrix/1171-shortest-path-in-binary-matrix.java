class Solution {
    class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int size = 0, n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<Pos> queue = new ArrayDeque<>();

        Pos Null = new Pos(-1, -1);
        queue.add(Null);
        queue.add(new Pos(0, 0));
        Pos track = new Pos(0, 0);

        while (!queue.isEmpty()) {
            Pos c = queue.remove();

            if (c == Null) {
                size++;
                if (!queue.isEmpty())
                    queue.add(Null);
                continue;
            } else
                track = c;

            if (c.x == n - 1 && c.y == n - 1)
                break;

            for (int i = c.x - 1; i < c.x + 2; i++)
                for (int j = c.y - 1; j < c.y + 2; j++)
                    if ((i != c.x || j != c.y) && i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0) {
                        queue.add(new Pos(i, j));
                        grid[i][j] = 1;
                    }
        }

        return (track.x == n - 1 && track.y == n - 1) ? size : -1;
    }
}