class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++)
            System.arraycopy(mat[i], 0, copy[i], 0, n);

        for (int[] i : mat)
            rotate(i, k);

        for (int i = 0; i < m; i++)
            if (!Arrays.equals(mat[i], copy[i]))
                return false;

        return true;
    }

    public void rotate(int[] nums, int k) {
        if (k == 0)
            return;

        k %= nums.length;

        int i, j;

        i = 0;
        j = nums.length - k - 1;
        while (i < j) {
            int temp = nums[i % nums.length];
            nums[i % nums.length] = nums[j % nums.length];
            nums[j % nums.length] = temp;
            i++;
            j--;
        }

        i = nums.length - k;
        j = nums.length - 1;
        while (i < j) {
            int temp = nums[i % nums.length];
            nums[i % nums.length] = nums[j % nums.length];
            nums[j % nums.length] = temp;
            i++;
            j--;
        }

        i = 0;
        j = nums.length - 1;
        while (i < j) {
            int temp = nums[i % nums.length];
            nums[i % nums.length] = nums[j % nums.length];
            nums[j % nums.length] = temp;
            i++;
            j--;
        }
    }
}