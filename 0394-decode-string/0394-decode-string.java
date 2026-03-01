class Solution {
    int n;

    public String decodeString(String s) {
        n = s.length() + 2;
        return decodeString("[".concat(s).concat("]"), new StringBuilder(), new int[] { 0 });
    }

    private String decodeString(String s, StringBuilder sb, int[] i) {
        boolean start = false;
        int rep = 0;
        while (i[0] < n) {
            char c = s.charAt(i[0]);
            if (Character.isDigit(c) && !start) {
                rep *= 10;
                rep += c - '0';
            } else if (Character.isDigit(c) && start) {
                sb.append(decodeString(s, new StringBuilder(), i));
            } else if (c == '[' && !start) {
                start = true;
            } else if (c == ']' && start) {
                break;
            } else {
                sb.append(c);
            }
            i[0]++;
        }
        return sb.toString().repeat(rep == 0 ? 1 : rep);
    }
}