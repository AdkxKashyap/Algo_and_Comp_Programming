public class lc931 {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix.length;j++){
               int best=matrix[i+1][j];
               if(j>0){
                   best=Math.min(best,matrix[i+1][j-1]);
               }
               if(j+1<matrix.length){
                   best=Math.min(best,matrix[i+1][j+1]);
               }
               
               matrix[i][j]=best+matrix[i][j];
            }
        }
        int finalBest=Integer.MAX_VALUE;
        for(int x:matrix[0]){
           finalBest=Math.min(finalBest, x);
        }
        return finalBest;
   
    }

    public static void main(String[] args) {
        lc931 test=new lc931();
        int matrix[][]={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(test.minFallingPathSum(matrix));
        
    }
}
