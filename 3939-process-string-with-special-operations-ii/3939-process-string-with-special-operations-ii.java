class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    if (len > 0)
                        len--;
                    break;
                case '#':
                    len *= 2;
                    break;
                case '%':
                    break;
                default:
                    len++;
                    break;
            }
        }

        if (k + 1 > len)
            return '.';

        for (int i = n - 1; i > -1; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    len++;
                    break;
                case '#':
                    if (k + 1 > (len + 1) / 2)
                        k -= len / 2;
                    len = (len + 1) / 2;
                    break;
                case '%':
                    k = len - k - 1;
                    break;
                default:
                    if (k + 1 == len)
                        return c;
                    len--;
                    break;
            }
        }

        return '.';
    }
}