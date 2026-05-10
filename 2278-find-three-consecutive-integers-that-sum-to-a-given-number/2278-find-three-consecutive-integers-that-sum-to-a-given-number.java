class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            num /= 3L;
            return new long[] { num - 1, num, num + 1 };
        } else
            return new long[0];
    }
}