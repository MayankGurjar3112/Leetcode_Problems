class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = 0;

        for (int i : nums)
            if (i > -1)
                n++;

        if (n == 0)
            return nums;
            
        int[] temp = new int[n];

        for (int i = 0, j = 0; i < nums.length; i++)
            if (nums[i] > -1)
                temp[j++] = nums[i];

        rotate(temp, k);

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] > -1)
                nums[i] = temp[j++];
        }

        return nums;
    }

    private void rotate(int[] nums, int k) {
        if (k == 0)
            return;

        k %= nums.length;

        int i, j;

        i = 0;
        j = k - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        i = k;
        j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        i = 0;
        j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}