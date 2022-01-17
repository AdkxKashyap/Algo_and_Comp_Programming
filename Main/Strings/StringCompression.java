package Main.Strings;

import java.util.Scanner;

public class StringCompression {
    public static String compression1(String str){
		// write your code here
        int i=1;
        String res="";
        res=res+str.charAt(0);
        for( i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                res+=str.charAt(i);
            }
        }

		return res;
	}

	public static String compression2(String str){
		// write your code here
        int i=1;
        String res="";
        res=res+str.charAt(0);
        int count=1;
        for( i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }
            else{
                if(count!=1)res+=count;
                count=1;
                res+=str.charAt(i);
            }
        }
        if(count>1)return res+count;
		
        return res;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}
}
