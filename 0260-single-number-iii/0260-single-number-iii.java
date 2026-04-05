class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) 
                set.remove(i);
            else 
                set.add(i);
        }

        int n = set.size();
        int[] result = new int[n];
        int j = 0;

        for (int i : set)
            result[j++] = i;

        return result;
    }
}