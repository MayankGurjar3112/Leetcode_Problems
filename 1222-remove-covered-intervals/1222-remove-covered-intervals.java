class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int c = Integer.compare(a[0], b[0]);
            if (c == 0)
                return Integer.compare(b[1] - b[0], a[1] - a[0]);
            return c;
        });

        int max = 0;
        int count = 0;

        for (int[] i : intervals) {
            if (i[1] > max) {
                count++;
                max = i[1];
            }
        }

        return count;
    }
}