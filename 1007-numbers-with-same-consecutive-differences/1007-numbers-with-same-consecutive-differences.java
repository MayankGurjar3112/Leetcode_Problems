class Solution {
    Set<Integer> list = new HashSet<>();
    int n;
    int k;
    
    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        
        for (int i = 1; i < 10; i++)
            backtrack(i);

        int[] arr = new int[list.size()];
        int i = 0;
        for (int j : list)
            arr[i++] = j; 

        return arr; 
    }

    private void backtrack(int i) {
        int d = i % 10;

        if ((int) Math.log10(i) == n - 1) {
            list.add(i);
            return;
        }

        if (d + k < 10)
            backtrack(i * 10 + (d + k));
        if (d - k > -1)
            backtrack(i * 10 + (d - k));
    }
}