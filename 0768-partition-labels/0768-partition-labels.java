class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i > -1; i--) 
            if (!map.containsKey(c[i] - 'a')) 
                map.put(c[i] - 'a', i);

        List<Integer> list = new ArrayList<>();

        int part = -1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int x = c[i] - 'a';
            part = Math.max(map.get(x), part);
            if (part == i) {
                list.add(part - start + 1);
                part = -1;
                start = i + 1;
            }
        }

        return list;
    }
}