import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=nGWQlXracRM&t=305s

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastPos=new int[26];
        int lPointer=0,rPointer=0;
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            lastPos[S.charAt(i)-'a']=i;
        }
        for(int i=0;i<S.length();i++){
            rPointer=rPointer<lastPos[S.charAt(i)-'a']?lastPos[S.charAt(i)-'a']:rPointer;
            if(rPointer==i){
                res.add(i-lPointer);
                lPointer=i;
            }
        }
        return res;
    }
}
