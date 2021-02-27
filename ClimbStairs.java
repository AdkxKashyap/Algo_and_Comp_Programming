//find distinct steps
// class Solution {
//     int memo[]=new int[46];
//     public int climbStairs(int n) {
        
//         if(n==0 || n==1){
//             return 1;
//         }

//         if(memo[n]!=0){
//             return memo[n];
//         }

//         return memo[n]=climbStairs(n-1)+climbStairs(n-2);
        
//     }
    
// }

//tabular

class ClimbStairs {
    
    public int climbStairs(int n) {
       int i=2;
       int memo[]=new int[n+1];
       memo[0]=1;memo[1]=1;
       while(i<=n){
        memo[i]=memo[i-1]+memo[i-2];
        System.out.println(memo[i]);
        i++;
       }
      
       return memo[i-1];
    }
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(2));
    }
    
}
