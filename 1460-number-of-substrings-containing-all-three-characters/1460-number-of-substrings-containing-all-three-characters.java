class Solution {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastPos = { -1, -1, -1 };
        int count = 0;

        for (int i = 0; i < n; i++) {
            lastPos[s.charAt(i) - 'a'] = i;
            count += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }

        return count;
    }
}