//if arr[i] needs to be removed than evenSum and oddSum before it remains same and after arr[i ]evenSUm becomes odd sum and odd sum becomes even. 
//right odd sum will become right even sum ,
// if even index elem is removed and and will be added to left even sum and vice versa

class WaysToMakeFair {
    public int waysToMakeFair(int[] A) {
       int count=0,leftEvenSum=0,rightEvenSum=0,leftOddSum=0,rightOddSum=0;
       for(int i=0;i<A.length;i++){
        if(i%2==0){
            rightEvenSum+=A[i];
        }
        else{
            rightOddSum+=A[i];
        }
       }

       for(int i=0;i<A.length;i++){
           if(i%2==0){
               rightEvenSum-=A[i];
               if(rightOddSum+leftEvenSum==leftOddSum+rightEvenSum)count++;
               leftEvenSum+=A[i];
           }
           else{
               rightOddSum-=A[i];
               if(leftEvenSum+rightOddSum==rightEvenSum+leftOddSum)count++;
               leftOddSum+=A[i];
           }
       }
       return count;
     }
     public static void main(String[] args) {
         int arr[]={2,1,6,4};
         System.out.println(new WaysToMakeFair().waysToMakeFair(arr));

     }
 }