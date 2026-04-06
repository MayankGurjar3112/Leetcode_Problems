class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;
        
        for (int i : nums) sum += i;

        if (goal < sum) {
            long count = 0L;
            long small = sum - goal;
            return (int) ((small / limit) + (small % limit > 0 ? 1 : 0));
        } else if (goal > sum) {
            long large = goal - sum;
            return (int) ((large / limit) + (large % limit > 0 ? 1 : 0));
        } else 
            return 0;
    }
}