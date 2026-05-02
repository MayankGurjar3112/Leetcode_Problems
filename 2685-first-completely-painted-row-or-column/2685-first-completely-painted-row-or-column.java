class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                map.put(mat[i][j], new int[] { i, j });

        int[] row = new int[m];        
        int[] col = new int[n];    

        Arrays.fill(row, n);    
        Arrays.fill(col, m);

        for (int i = 0; i < arr.length; i++) {
            int[] t = map.get(arr[i]);
            row[t[0]]--;
            col[t[1]]--;
            if (row[t[0]] == 0 || col[t[1]] == 0)
                return i;
        }

        return -1; 
    }
}