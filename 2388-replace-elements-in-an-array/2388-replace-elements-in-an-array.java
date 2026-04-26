class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) 
            map.put(nums[i], i);

        for (int[] i : operations) {
            int idx = map.get(i[0]);
            nums[idx] = i[1];
            map.remove(i[0]);
            map.put(i[1], idx);
        }

        return nums;
    }
}