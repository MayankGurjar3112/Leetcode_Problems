class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        s = "0".concat(s);
        int n = s.length();
        int[] arr = new int[n];
        arr[0] = 0;

        for (int i = 1; i < n; i++) 
            arr[i] = arr[i - 1] + s.charAt(i) - '0';

        if (arr[n - 1] < k)
            return "";

        int i = 0, j = 0;
        int vi = 0, vj = k;
        int min = n;
        String cur = s;
        while (vj <= arr[n - 1]) {
            while (i + 1 < n && arr[i + 1] != vi + 1)
                i++;
            while (j < n && arr[j] != vj)
                j++;
            String sub = s.substring(i + 1, j + 1);
            if (min == j - i) 
                cur = (cur.compareTo(sub) < 1) ? cur : sub;
            else if (min > j - i) {
                min = j - i;
                cur = sub;
            }
            vi++;
            vj++;
        }
        
        return cur;
    }
}