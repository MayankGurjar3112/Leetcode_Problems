class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = (i - 1 > -1) ? nums[i - 1] : Integer.MAX_VALUE;
            int n = (i + 1 < nums.length) ? nums[i + 1] : Integer.MAX_VALUE;
            if (nums[i] >= Math.min(p, n)) {
                int t = nums[i] - Math.min(p, n) + 1;
                if (i % 2 == 0)
                    n1 += t;
                else 
                    n2 += t;
            }
        }
        return Math.min(n1, n2);
    }
}