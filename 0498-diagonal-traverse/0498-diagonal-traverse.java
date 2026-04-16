class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int N = matrix.length;
        int M = matrix[0].length;

        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int d = 0; d < N + M - 1; d++) {
            list.clear();

            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            while (r < N && c > -1) {
                list.add(matrix[r][c]);
                ++r;
                --c;
            }

            if (d % 2 == 0)
                Collections.reverse(list);

            for (int i = 0; i < list.size(); i++)
                result[k++] = list.get(i);
        }

        return result;
    }
}