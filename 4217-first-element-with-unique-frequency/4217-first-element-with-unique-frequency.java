class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums)
            map1.put(i, map1.getOrDefault(i, 0) + 1);

        List<Integer> list = new ArrayList<>(map1.keySet());
        
        for (int i : list) 
            map2.put(map1.get(i), map2.getOrDefault(map1.get(i), 0) + 1);

        for (int i : nums) 
            if (map2.get(map1.get(i)) == 1)
                return i;

        return -1;
    }
}