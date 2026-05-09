class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        int[] map = new int[26];

        for (int i = 0; i < n; i++)
            map[s.charAt(i) - 'a']++;

        char c = ' ';
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char t = (char) (i + 'a');
            if (map[i] % 2 == 1)
                c = t;
            sb1.append(("" + t).repeat(map[i] / 2));
            sb2.append(("" + t).repeat(map[i] / 2));
        }

        if (n % 2 == 1)
            sb1.append(c);
        sb2.reverse();
        sb1.append(sb2);

        return sb1.toString();
    }
}