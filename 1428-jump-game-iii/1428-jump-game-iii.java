class Solution {
    boolean[] visit;
    int[] arr;
    int n, start;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        this.arr = arr;
        this.start = start;
        visit = new boolean[n];
        return dfs(start);
    }

    private boolean dfs(int i) {
        if (i >= n || i < 0 || visit[i])
            return false;

        visit[i] = true;

        if (arr[i] == 0)
            return true;

        return dfs(i + arr[i]) || dfs(i - arr[i]);
    }
}