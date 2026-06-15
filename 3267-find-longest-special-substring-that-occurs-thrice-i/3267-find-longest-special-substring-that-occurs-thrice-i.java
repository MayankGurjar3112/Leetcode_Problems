class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ci = s.charAt(i);
            for (int j = i + 1; j <= n; j++) {
                char cj = s.charAt(j - 1);
                if (ci != cj)
                    break;
                String t = s.substring(i, j);
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        int max = -1;
        for (String i : list)
            if (map.get(i) >= 3)
                max = Math.max(max, i.length());

        return max;
    }
}