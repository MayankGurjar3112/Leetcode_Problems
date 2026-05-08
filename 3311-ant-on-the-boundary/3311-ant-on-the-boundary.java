class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0, count = 0;

        for (int i : nums) {
            sum += i;
            if (sum == 0)
                count++;
        } 

        return count;
    }
}