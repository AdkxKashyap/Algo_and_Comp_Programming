package Main.Strings;

import java.util.Scanner;

public class PrintPalString {
    public static void solution(String str){
		//write your code here
		for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(i==j)System.out.println(str.substring(i, j+1));
                else{
                    String tmp=str.substring(i, j+1);
                    StringBuilder strRev=new StringBuilder();
                    strRev.append(tmp);
                    strRev.reverse();
                    if(tmp.equals(strRev.toString()))System.out.println(tmp);
                }
            }
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}
}
