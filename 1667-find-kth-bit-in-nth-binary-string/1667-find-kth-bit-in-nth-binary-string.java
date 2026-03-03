class Solution {
    public char findKthBit(int n, int k) {
        String s1N = "0";
        String s1NR = "0";
        String s1I = "1";
        String s1IR = "1";
        StringBuilder s2N = new StringBuilder();
        StringBuilder s2I = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            s2N.append(s1N);
            s2N.append('1');
            s2N.append(s1IR);

            s2I.append(s1I);
            s2I.append('0');
            s2I.append(s1NR);

            s1N = s2N.toString();
            s1NR = s2N.reverse().toString();
            s1I = s2I.toString();
            s1IR = s2I.reverse().toString();
            s2N = new StringBuilder();
            s2I = new StringBuilder();
        }

        return s1N.charAt(k - 1);
    }
}