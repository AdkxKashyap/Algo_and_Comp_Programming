class Rotate {
    public void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    public void reverse(int[][] matrix) {
        //we will reverse each row
        for(int r = 0; r < matrix.length; r++) {
            int left = 0;
            int right = matrix.length-1;
            while(left < right) {
                int tmp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = tmp;
                left++;
                right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        //1 - transpose
        transpose(matrix);
        //2 - Rotate
        reverse(matrix);
    }
}