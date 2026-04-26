class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long count = 1;
        int n = nums1.length;
        int last = nums2[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            count += Math.abs(nums1[i] - nums2[i]);
            if ((last <= nums2[i] && last >= nums1[i]) || (last >= nums2[i] && last <= nums1[i]))
                min = 0;
            else {
                min = Math.min(Math.abs(nums1[i] - last), min);
                min = Math.min(Math.abs(nums2[i] - last), min);
            }
        }

        return count + min;
    }
}