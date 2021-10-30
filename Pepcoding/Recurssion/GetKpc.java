import java.io.*;
import java.util.*;

public class GetKpc {
    public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str=in.next();

        ArrayList<String>res=getKPC(str);
        System.out.println(res);
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String>bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        int index=str.charAt(0)-'0';
        String code=codes[index];
        ArrayList<String>tmpRes=getKPC(str.substring(1));
        ArrayList<String>res=new ArrayList<>();
        for(int i=0;i<code.length();i++){
            char ch=code.charAt(i);
            for(String s:tmpRes){
                res.add(ch+s);
            }
        }
        return res;
    }

}