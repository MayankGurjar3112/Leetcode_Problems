class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;

        for (int i : asteroids) 
            if (m >= i)
                m += i;
            else
                return false;

        return true;
    }
}