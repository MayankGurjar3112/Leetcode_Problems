class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                flag = false;
                max = Math.max(max, sum1 + sum2);
                sum2 = sum1;
                sum1 = 0;
            } else sum1++;
        }

        max = Math.max(max, sum1 + sum2);
        
        return flag ? max - 1 : max;
    }
}