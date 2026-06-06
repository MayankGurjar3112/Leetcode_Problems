class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = nums[0];
        r[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) 
            l[i] = Math.min(l[i - 1], nums[i]);

        for (int i = n - 2; i > -1; i--) 
            r[i] = Math.min(r[i + 1], nums[i]);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) 
            if (nums[i] > l[i - 1] && nums[i] > r[i + 1])
                min = Math.min(min, l[i - 1] + nums[i] + r[i + 1]);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}