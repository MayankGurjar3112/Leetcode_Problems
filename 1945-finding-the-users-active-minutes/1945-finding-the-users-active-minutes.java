class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] ans = new int[k];

        for (int[] i : logs) {
            Set<Integer> set = map.getOrDefault(i[0], new HashSet<>());
            set.add(i[1]);
            map.put(i[0], set);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        for (int i : list)
            ans[map.get(i).size() - 1]++;

        return ans;
    }
}