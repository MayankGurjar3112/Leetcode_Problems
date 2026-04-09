class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '1')
                addOne(sb);
            else
                sb.setLength(sb.length() - 1);
            count++;
        }

        return count;
    }

    private void addOne(StringBuilder sb1) {
        StringBuilder sb2 = new StringBuilder("0");
        sb1.setLength(sb1.length() - 1);
        while (sb1.length() > 0 && sb1.charAt(sb1.length() - 1) == '1') {
            sb1.setLength(sb1.length() - 1);
            sb2.append('0');
        }
        if (sb1.length() > 0) {
            sb1.setLength(sb1.length() - 1);
            sb1.append('1');
            sb1.append(sb2);
        } else {
            sb1.append('1');
            sb1.append(sb2);
        }
    }
}