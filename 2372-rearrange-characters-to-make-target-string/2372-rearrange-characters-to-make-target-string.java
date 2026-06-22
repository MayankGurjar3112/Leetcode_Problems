class Solution {
    public int rearrangeCharacters(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (char c : s.toCharArray())
            map1[c - 'a']++;
        for (char c : t.toCharArray())
            map2[c - 'a']++;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++)
            if (map2[i] != 0)
                min = Math.min(min, map1[i] / map2[i]);

        return min;
    }
}