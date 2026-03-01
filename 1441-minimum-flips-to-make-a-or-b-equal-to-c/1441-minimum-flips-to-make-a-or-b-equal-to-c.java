class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while (c != 0 || b != 0 || a != 0) {
            int x = 1 & a;
            int y = 1 & b;
            int z = 1 & c;

            a >>= 1;
            b >>= 1;
            c >>= 1;

            if ((z == 0 && y == 0 && x == 0) || (z == 1 && (z == x || z == y)))
                continue;

            if (x != z && y != z) {
                if (z == 0)
                    count += 2;
                else
                    count++;
            } else if (x != z || y != z)
                count++;
        }

        return count;
    }
}