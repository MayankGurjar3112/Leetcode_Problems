class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, pivot);

        int j = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] < pivot)
                ans[j++] = nums[i];

        int k = n - 1;
        for (int i = n - 1; i > -1; i--)
            if (nums[i] > pivot)
                ans[k--] = nums[i];

        return ans;
    }
}