class Solution {

    int n;

    public boolean findRotation(int[][] mat, int[][] target) {
        n = mat.length;
        if (n == 1 && mat[0][0] == target[0][0]) {
            return true;
        } else if (Arrays.deepEquals(mat, target)) {
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                mat = transpose(mat);
                mat = reverse(mat);
                if (Arrays.deepEquals(mat, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] transpose(int[][] matrix) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return matrix;
    }

    public int[][] reverse(int[][] matrix) {
        int temp;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
        return matrix;
    }

}