class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> arrayList = new ArrayList<>();
        int a, b;

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][0] <= intervals[i + 1][1]) {
                a = (intervals[i][0] > intervals[i + 1][0]) ? intervals[i + 1][0] : intervals[i][0];
                b = (intervals[i][1] < intervals[i + 1][1]) ? intervals[i + 1][1] : intervals[i][1];
                intervals[i + 1] = new int[] { a, b };
            } else {
                arrayList.add(intervals[i]);
            }
        }
        arrayList.add(intervals[intervals.length - 1]);

        int[][] result = new int[arrayList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}