class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zero = 0;

        for (int i : arr) {
            if (i == 0)
                zero++;
            set.add(i);
        }

        for (int i : arr) 
            if ((i == 0 && zero > 1) || (i != 0 && set.contains(i * 2)))
                return true;

        return false;
    }
}