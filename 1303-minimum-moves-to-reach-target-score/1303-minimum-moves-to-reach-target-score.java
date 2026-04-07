class Solution {
    public int minMoves(int target, int mD) {
        int count = 0;

        while (target > 1 && mD > 0) {
            if (target % 2 == 0) {
                target /= 2;
                mD--;
            } else 
                target--;
            count++;
        }

        return count + target - 1;
    }
}