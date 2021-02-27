//lc392
class Solution {
    public boolean isSubsequence(String s, String t) {
        int lastVisited=0;
        int i;
        for( i=0;i<s.length();i++){    
            
            while(lastVisited<t.length()){
                if(s.charAt(i)==t.charAt(lastVisited)){     
                    System.out.println(lastVisited);
                    break;
                }
               lastVisited++;
            }
            if(lastVisited==t.length()){
                break;
            }
            lastVisited++;
        }
        if(i==s.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s="aaaaaa";
        String t="bbaaaa";
        
        boolean res=new Solution().isSubsequence(s,t);
        System.out.println(res);
    }
}
