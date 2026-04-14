class Solution {
    int[][] land;
    int m, n;

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        m = land.length;
        n = land[0].length;
        this.land = land;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (land[i][j] == 1) {
                    int[] arr = new int[4];
                    Arrays.fill(arr, -1);
                    dfs(i, j, arr);
                    list.add(arr);
                }

        return list.stream().toArray(int[][]::new);
    }

    private void dfs(int i, int j, int[] arr) {
        if (i >= m || j >= n || land[i][j] == 0)
            return;

        if (arr[0] == -1) {
            arr[0] = i;
            arr[1] = j;
        }

        land[i][j] = 0;

        arr[2] = Math.max(arr[2], i);
        arr[3] = Math.max(arr[3], j);

        dfs(i + 1, j, arr);
        dfs(i, j + 1, arr);
    }
}