class Solution {
    public boolean canTransform(String start, String result) {
        int n = start.length();
        int i = 0, j = 0;

        while (true) {
            char s = ' ', r = ' ';
            boolean S = false, R = false;

            while (i < n && (r = start.charAt(i)) == 'X') 
                i++;

            while (j < n && (s = result.charAt(j)) == 'X') 
                j++;

            if (i == n && j == n)
                break;
            else if ((i == n && j != n) || (i != n && j == n) || (s != r) || (s == 'R' && i > j) || (s == 'L' && i < j))
                return false;

            i++;
            j++;
        }

        return true;
    }
}