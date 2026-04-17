class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                min = Math.min(i - map.get(nums[i]), min);
            map.put(reverse(nums[i]), i);
        }
  
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int reverse(int n) {
        int m = 0;

        while (n > 0) {
            m *= 10;
            m += (n % 10);
            n /= 10;
        }

        return m;
    }
}