class Solution {
    public int minSteps(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (char c : s.toCharArray())
            map1[c - 'a']++;

        for (char c : t.toCharArray())
            map2[c - 'a']++;

        int count = 0;

        for (int i = 0; i < map1.length; i++) 
            count += Math.abs(map1[i] - map2[i]);

        return count;
    }
}