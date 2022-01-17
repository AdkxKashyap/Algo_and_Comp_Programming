package Main.Recurssion;
import java.util.ArrayList;
import java.util.Scanner;

public class GetSubseq {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str=in.next();

        ArrayList<String>res=new ArrayList<>();
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch=str.charAt(0);
        String roq=str.substring(1);
        ArrayList<String>tmpRes=gss(roq);
        ArrayList<String>res=new ArrayList<>();
        for(String s:tmpRes){
            res.add("-"+s);
        }
        for(String s:tmpRes){
            res.add(ch+s);
        }
        return res;
    }
}
