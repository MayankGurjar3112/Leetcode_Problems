class Solution {

    private static final double EPS = 1e-7;

    public long minNumberOfSeconds(int mh, int[] wt) {
        int max = 0;
        for (int t : wt)
            max = Math.max(max, t);

        long l = 1;
        long r = ((long) max * mh * (mh + 1)) / 2;
        long ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;

            for (int t : wt) {
                long work = mid / t;
                long k = (long) ((-1.0 + Math.sqrt(1 + work * 8)) / 2 + EPS);
                cnt += k;
            }

            if (cnt >= mh) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}