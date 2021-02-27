public class lc1277 {
    public int countSquares(int[][] matrix) {
        int i=0;int j=0;
        int count=0;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>=1 && i>0 && j>0){
                    matrix[i][j]=Math.min(Math.min(matrix[i][j-1], matrix[i-1][j]), Math.min(matrix[i-1][j],  matrix[i-1][j-1]))+matrix[i][j];
                    
                }
                count+=matrix[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int array[][]=
          { 
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
          };
          System.out.println(new lc1277().countSquares(array));
        }
    }


//           int i=0;int j=0;
//           int count=0;
//           for(i=0;i<matrix.length;i++){
//               for(j=0;j<matrix[0].length;j++){
//                   if(matrix[i][j]>=1){
//                       if(i-1<0 || j-1<0){
//                           count+=matrix[i][j];
//                           continue;
//                       }
//                       if(matrix[i][j-1]==0 || matrix[i-1][j]==0 || matrix[i-1][j-1]==0){
//                           count+=matrix[i][j];
//                           continue;
//                       }
//                       if((matrix[i][j-1]+matrix[i-1][j]+matrix[i-1][j-1])%3==0){
//                           matrix[i][j]=matrix[i][j]+matrix[i][j-1];
//                           // count+=matrix[i][j];
//                       }
//                       else{
//                           matrix[i][j]++;
//                       }
//                       count+=matrix[i][j];
//                   }
//               }
//           }
//           return count;
          
//     }
// }
