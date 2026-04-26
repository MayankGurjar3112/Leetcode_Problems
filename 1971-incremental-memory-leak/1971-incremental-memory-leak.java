class Solution {
    public int[] memLeak(int m1, int m2) {
        int i = 0;

        for (;; i++)
            if (m1 >= m2 && m1 >= i)
                m1 -= i;
            else if (m2 >= i)
                m2 -= i;
            else 
                break;

        return new int[] { i, m1, m2 };
    }
}