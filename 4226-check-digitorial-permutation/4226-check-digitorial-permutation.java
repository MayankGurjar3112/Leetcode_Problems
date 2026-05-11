class Solution {
    final int[] fact = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public boolean isDigitorialPermutation(int n) {
        int[] num1 = getArr(n);
        
        int sum = 0;

        for (int i : num1) 
            if (i != -1)
                sum += fact[i];
        
        int[] num2 = getArr(sum);

        Arrays.sort(num1);
        Arrays.sort(num2);

        for (int i = 0; i < 10; i++) 
            if (num1[i] != num2[i])
                return false;

        return true;
    }

    private int[] getArr(int n) {
        int[] arr = new int[10];

        Arrays.fill(arr, -1);

        int i = 0;
        while (n > 0) {
            arr[i++] = n % 10;
            n /= 10;
        }

        return arr;
    }
}