class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] chars = s.toCharArray();
        int m = chars.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int x = startPos[0];
            int y = startPos[1];
            
            for (int j = i; j < m; j++) {
                char c = chars[j];
                
                if (c == 'R') 
                    y++;
                else if (c == 'L')
                    y--;
                else if (c == 'D')
                    x++;
                else 
                    x--;

                if (x < 0 || y < 0 || x >= n || y >= n)
                    break;
                else 
                    ans[i]++;
            }
        }

        return ans;
    }
}