class Solution {
    static StringBuilder sb = new StringBuilder("122");
    static int[] p = new int[100001];
    static String s;
    
    static {
        boolean cur = true;
        int i = 2;
        while (sb.length() < 100003) {
            sb.append((cur ? "1" : "2").repeat(sb.charAt(i++) == '1' ? 1 : 2));
            cur = !cur; 
        }    

        s = sb.toString();

        p[0] = 1;
        for (int j = 1; j < 100001; j++) 
            p[j] = p[j - 1] + (sb.charAt(j) == '1' ? 1 : 0);
    }

    public int magicalString(int n) {
        return p[n - 1];
    }
}