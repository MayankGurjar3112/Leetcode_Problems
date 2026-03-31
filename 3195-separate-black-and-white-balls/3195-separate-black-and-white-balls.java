class Solution {
    public long minimumSteps(String s) {
        int zero = 0;
        long steps = 0;
        int n = s.length();
        
        for (int i = n - 1; i > -1; i--) {
            int j = s.charAt(i) - '0';
            if (j == 0) zero++;
            else steps += zero;
        }

        return steps;
    }
}