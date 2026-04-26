class Solution {
    final int[] rep = { 1, 1, 4, 4, 2, 1, 1, 4, 4, 2 };

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];

            a %= 10;
            b %= rep[a];
            int t1 = (int) Math.pow(a, b == 0 ? rep[a] : b) % 10;
            int t2 = t1;

            for (int j = 1; j < c; j++)
                t2 = (t2 * t1) % m;

            if (t2 % m == target)
                list.add(i);
        }

        return list;
    }
}