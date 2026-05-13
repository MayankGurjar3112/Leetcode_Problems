class Solution {
    public int minRemovals(int[] A, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for (int a : A) {
            target ^= a;
            List<Map.Entry<Integer, Integer>> items = new ArrayList<>(dp.entrySet());
            for (Map.Entry<Integer, Integer> entry : items) {
                int v = entry.getKey(), c = entry.getValue();
                int nextV = v ^ a;
                if (c + 1 < dp.getOrDefault(nextV, 50)) {
                    dp.put(nextV, c + 1);
                }
            }
        }
        return dp.getOrDefault(target, -1);
    }
}