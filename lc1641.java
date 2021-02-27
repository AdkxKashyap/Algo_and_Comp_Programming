//check https://www.youtube.com/watch?v=gdt7HQF56OI
//for o{1} we can use combinatorics check
public class lc1641 {
    public int countVowelStrings(int n) {
        int i,k,count=1;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 5;
        }
        int memo[]=new int[5];
        memo[4]=1;
        for(i=2;i<=n;i++){
            for(k=3;k>=0;k--){
                if(memo[k]==0){
                    memo[k]=1;
                }
                memo[k]=memo[k]+memo[k+1];
                if(i==n){
                    count+=memo[k];
                }
            }
        }
        return count;
     }
}
