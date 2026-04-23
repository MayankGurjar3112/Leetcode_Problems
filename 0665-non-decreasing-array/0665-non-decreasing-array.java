class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;

        for (int i = 1, err = 0; i < n; i++) 
            if (nums[i - 1] > nums[i]) 
                if (err++ > 0 || (i > 1 && i < n - 1 && nums[i - 2] > nums[i] && nums[i + 1] < nums[i - 1]))
                    return false;

        return true;
    }
}