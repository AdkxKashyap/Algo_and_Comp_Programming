//Palindromic Substrings
//see https://www.youtube.com/watch?v=XmSOWnL6T_I
//lc647
class Solution {
    public int countSubstrings(String s) {
        boolean memo[][]= new boolean[s.length()][s.length()]; 
        int g,i,j,count=0;
        for(g=0;g<s.length();g++){
            for(i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                    memo[i][j]=true;
                }
                else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        memo[i][j]=true;
                    }
                    else{
                        memo[i][j]=false;
                    }           
                }
                else {
                    if(s.charAt(i)==s.charAt(j) && memo[i-1][j-1]==true){
                        memo[i][j]=true;
                    }
                    else{
                        memo[i][j]=false;
                    }
                }
                if(memo[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}