class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0)
            return true;

        for (int i = 1; i < num; i++) 
            if (i + reverse(i) == num) 
                return true;

        return false;
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