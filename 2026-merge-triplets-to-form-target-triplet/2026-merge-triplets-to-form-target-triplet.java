class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] t) {
        int[] x = new int[] { t[0], t[1], t[2] };
        
        for (int[] i : triplets) {
            if (x[0] < i[0] || x[1] < i[1] || x[2] < i[2])
                continue;
            if (t[0] == i[0])
                t[0] = -1;
            if (t[1] == i[1])
                t[1] = -1;
            if (t[2] == i[2])
                t[2] = -1;
            if (t[0] + t[1] + t[2] == -3)
                break;
        }

        return t[0] + t[1] + t[2] == -3;
    }
}