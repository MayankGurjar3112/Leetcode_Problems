class FindSumPairs {
    Map<Integer, Integer> m1 = new HashMap<>();
    Map<Integer, Integer> m2 = new HashMap<>();
    int[] nums1;
    int[] nums2;
    List<Integer> list;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for (int i : nums1)
            m1.put(i, m1.getOrDefault(i, 0) + 1);
        for (int i : nums2)
            m2.put(i, m2.getOrDefault(i, 0) + 1);

        list = new ArrayList<>(m1.keySet());
    }
    
    public void add(int index, int val) {
        int temp = nums2[index];
        nums2[index] += val;
        if (m2.get(temp) == 1)
            m2.remove(temp);
        else
            m2.put(temp, m2.get(temp) - 1);
        m2.put(nums2[index], m2.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        
        for (int i : list) {
            int diff = tot - i;

            if (m2.containsKey(diff))
                count += (m1.get(i) * m2.get(diff));
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */