class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 0;

        for (int i : arr) 
            if (prev + 1 < i)
                prev = prev + 1;
            else
                prev = i;
        
        return prev;
    }
}