class Solution {
    String[] strs;
    int size;
    int i = 0;

    public String getHappyString(int n, int k) {
        int span = (int) Math.pow(2, n - 1);
        size = span * 3;
        if (k > size)
            return "";

        strs = new String[size];

        for (int i = 97; i < 100; i++)
            backtrack(n, new StringBuilder("" + (char) i));

        return strs[k - 1];
    }

    private void backtrack(int n, StringBuilder sb) {
        if (n == 1) {
            strs[i++] = sb.toString();
        } else {
            int c = sb.charAt(sb.length() - 1);
            for (int i = 97; i < 100; i++) {
                if (c != i) {
                    sb.append((char) i);
                    backtrack(n - 1, sb);
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
}