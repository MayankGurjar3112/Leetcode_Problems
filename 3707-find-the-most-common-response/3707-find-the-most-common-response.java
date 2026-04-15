class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();

        for (List<String> i : responses) {
            Set<String> set = new HashSet<>();
            for (String j : i)
                if (!set.contains(j)) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    set.add(j);
                }
        }

        List<String> list = new ArrayList<>(map.keySet());
        int max = 0;
        String s = "";

        for (String i : list) {
            int val = map.get(i);
            if (max < val) {
                max = val;
                s = i;
            } else if (max == val) {
                if (s.compareTo(i) > 0)
                    s = i;
            }
        }

        return s;
    }
}