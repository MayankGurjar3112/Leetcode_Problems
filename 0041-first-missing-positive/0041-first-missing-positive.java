class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
            max = Math.max(i, max);
        }

        int i = 0;
        for (i = 1; i <= max; i++)
            if (!set.contains(i))
                return i;

        return i;
    }
}