class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] i : queries) {
            int idx = i[0];

            while (idx <= i[1]) {
                nums[idx] = (int) (((long) nums[idx] * i[3]) % 1000000007L);
                idx += i[2];
            }
        }

        for (int i = nums.length - 2; i > -1; i--)
            nums[i] ^= nums[i + 1];

        return nums[0];
    }
}