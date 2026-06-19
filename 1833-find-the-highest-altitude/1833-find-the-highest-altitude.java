class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int n = gain.length;
        for (int i = 1; i < n; i++) 
            max = Math.max(max, (gain[i] += gain[i - 1]));
        return Math.max(max, gain[0]);
    }
}