class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
            set.add(reverse(i));
        }

        return set.size();
    }

    private int reverse(int n) {
        int m = 0;

        while (n > 0) {
            m *= 10;
            m += (n % 10);
            n /= 10;
        }

        return m;
    }
}