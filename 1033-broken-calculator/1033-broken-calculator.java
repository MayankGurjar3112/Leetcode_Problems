class Solution {
    public int brokenCalc(int s, int t) {
        int count = 0;

        while (s != t) {
            if (t % 2 == 0 && s < t) 
                t /= 2;
            else 
                t++;
            count++;
        }

        return count;
    }
}