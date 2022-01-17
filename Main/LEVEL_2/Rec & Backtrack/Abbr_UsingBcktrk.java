import java.io.*;
import java.util.*;

public class Abbr_UsingBcktrk {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        if(pos == str.length()) {
            System.out.println(asf + (count > 0 ? count : ""));
            return;
        }
        //yes call -asf + count(if !0) + current char , reset count
        solution(str, asf + (count > 0 ? count : "") + str.charAt(pos), 0, pos + 1);
        //No call - Increment count
        solution(str, asf, count + 1, pos + 1);
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}