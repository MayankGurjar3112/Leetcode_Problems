class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') zero = true;
            else if (c == '1' && zero) return false;
        }
        return true;
    }
}