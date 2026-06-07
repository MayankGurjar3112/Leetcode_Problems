class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        Arrays.fill(ans, Integer.MAX_VALUE);

        boolean flag = false;
        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                flag = true;
                j = 0;
            }
            if (flag) 
                ans[i] = j++;
        }

        flag = false;
        for (int i = n - 1, j = 0; i > -1; i--) {
            if (s.charAt(i) == c) {
                flag = true;
                j = 0;
            }
            if (flag) 
                ans[i] = Math.min(ans[i], j++);
        } 

        return ans;
    }
}