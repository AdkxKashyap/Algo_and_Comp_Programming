import java.util.Arrays;

//lc1504
//https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
public class CountSubmatrWithAll_1 {
    public int numSubmat(int[][] mat) {
        int res=0;
        for(int startRow=0;startRow<mat.length;startRow++){
            int[] row=new int[mat[0].length];
            Arrays.fill(row, 1);
            for(int endRow=startRow;endRow<mat.length;endRow++){
                /**Count submatr from start row to end row.row[k]=1 means kth row from start to end matr has all 1s */
                for(int k=0;k<row.length;k++){
                    row[k]&=mat[endRow][k];
                }
                res+=countSubmatrInRow(row);
            }
        }
        return res;
    }
    public int countSubmatrInRow(int[] row){
        int res=0,length=0;
        for(int i=0;i<row.length;i++){
            length=row[i]==1?length+1:0;/**In a row r if r[i] is 1 than that is a valid submatr if r[i+1] also 1
                                          than len of valid submatr is 2  with total 2 1s so tot valid submatr=
                                            1 submatr of len 2 + 2 submatr of len 1=3.If r[i]=0 reset len since no submatr can be formed using that cell. */
            res+=length;
        }
        return res;
    }
}
