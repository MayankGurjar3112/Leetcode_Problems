class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        for (char c : text.toCharArray()) 
            map[c - 'a']++;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, map['b' - 'a']);
        min = Math.min(min, map['a' - 'a']);
        min = Math.min(min, map['n' - 'a']);
        min = Math.min(min, map['l' - 'a'] / 2);
        min = Math.min(min, map['o' - 'a'] / 2);
        return min;
    }
}