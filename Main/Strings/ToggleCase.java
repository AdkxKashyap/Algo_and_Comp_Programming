package Main.Strings;

import java.util.Scanner;

public class ToggleCase {
    
	public static String toggleCase(String str){
		//write your code here
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isLowerCase(ch)){
                sb.append(Character.toUpperCase(ch));
            }
            else sb.append(Character.toLowerCase(ch));
        }
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}
}
