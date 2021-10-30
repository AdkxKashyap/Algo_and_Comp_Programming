//see pepcoding vid and notes
class SudokuSolver
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        //  System.out.println(sudokuHelper(grid, 0, 0));
        return sudokuHelper(grid, 0, 0);
    }
    public static boolean  sudokuHelper(int[][] grid, int i, int j) {
        if(i == grid.length) {
            // printGrid(grid);
            return true;
            
        }
        boolean res = false;
        int nxtj = 0;
        int nxti = 0;
        //prep i and j for next jump
        if(j == grid[0].length - 1) {
             nxtj = 0;
             nxti = i + 1;
        }else {
             nxtj =  j + 1;
             nxti = i;
        }
        if(grid[i][j] != 0) {
               res = sudokuHelper(grid, nxti, nxtj);
               if(res) return true;
            
        }
        else {
             //po -> possibility
            for(int po = 1; po <= 9; po++) {
                
                if(isValid(grid, i, j, po)){
                    grid[i][j] = po;
                     res = sudokuHelper(grid, nxti, nxtj);
                     if(res) return true;
                      grid[i][j] = 0;
                }
               
            }
        }
        return res;
       
    }
    public static boolean isValid(int[][] grid, int i, int j, int val) {
        //check row
        for(int col = 0; col < 9; col++) {
           
                if(grid[i][col] == val) return false;
            
        }
        //check col
        for(int row = 0; row < 9; row++) {
            
                if(grid[row][j] == val) return false;
            
        }
        
        //check sub grid
        int si = 3 * (i/3);
        int sj = 3 * (j/3);
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(grid[si + r][sj + c] == val) return false;
            }
        }
        return true;
    }
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
