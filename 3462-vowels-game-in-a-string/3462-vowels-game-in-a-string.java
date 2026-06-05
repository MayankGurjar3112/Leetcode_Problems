class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        for (int j = 0; j < n; j++) {
            char i = s.charAt(j);
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u')
                return true;
        }
        return false;
    }
}