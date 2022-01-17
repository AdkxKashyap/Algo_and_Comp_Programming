package Main.Recurssion;
import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<String>res=getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if(n==0){
            ArrayList<String>bres=new ArrayList<String>();
            bres.add("");
            return bres;
        }
        if(n<0){
            ArrayList<String>bres=new ArrayList<String>();
            return bres;
        }
        ArrayList<String>res1=getStairPaths(n-1);
        ArrayList<String>res2=getStairPaths(n-2);
        ArrayList<String>res3=getStairPaths(n-3);
        ArrayList<String>mres=new ArrayList<String>();
        for(String s:res1){
            mres.add('1'+s);
        }
        for(String s:res2){
            mres.add('2'+s);
        }
        for(String s:res3){
            mres.add('3'+s);
        }
        return mres;
    }
}
