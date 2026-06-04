class Solution {
    static int[] p = new int[100001];
    
    static {
        for (int i = 100; i < 100001; i++) {
            int[] arr = ArrayOf(i);
            int count = 0;
            for (int j= 1; j < arr.length - 1; j++) {
                int a = arr[j - 1];
                int b = arr[j];
                int c = arr[j + 1];
                
                if ((a > b && c > b) || (a < b && c < b))
                    count++;
            }
            p[i] += p[i - 1] + count;
        }
    }

    public int totalWaviness(int num1, int num2) {
        return p[num2] - p[num1 - 1];
    }

    static private int[] ArrayOf(int n) {
        int[] arr = new int[(int) Math.log10(n) + 1];

        for (int i = arr.length - 1; i > -1; i--) {
            arr[i] = n % 10;
            n /= 10;
        }

        return arr;
    }
}