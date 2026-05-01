class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];

        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (j != i)
                    adj[j][i] = Integer.MAX_VALUE; 

        for (int[] i : edges) {
            adj[i[0]][i[1]] = i[2];
            adj[i[1]][i[0]] = i[2];
        }

        for (int k = 0; k < n; k++) 
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                
        int city = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) 
                if (adj[i][j] <= distanceThreshold)
                    count++;
            if (min >= count) {
                min = count;
                city = i;
            }
        }

        return city;
    }
}