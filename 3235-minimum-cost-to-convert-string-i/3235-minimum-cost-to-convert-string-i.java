class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] adj = new long[26][26];

        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                if (i != j)
                    adj[i][j] = Long.MAX_VALUE;

        for (int i = 0; i < original.length; i++)
            adj[original[i] - 'a'][changed[i] - 'a'] = Math.min(adj[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        
        for (int k = 0; k < 26; k++)
            for (int i = 0; i < 26; i++) 
                for (int j = 0; j < 26; j++)
                    if (adj[i][k] != Long.MAX_VALUE && adj[k][j] != Long.MAX_VALUE)
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

        long c = 0;
        int n = source.length();

        for (int i = 0; i < n; i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s == t)
                continue;

            if (adj[s][t] == Long.MAX_VALUE)
                return -1;
            
            c += adj[s][t]; 
        }

        return c;
    }
}