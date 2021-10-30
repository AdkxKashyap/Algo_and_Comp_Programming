import java.io.*;
import java.util.*;

public class AllPalindromicPermutations {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
	    
		if(cs == ts) {
		    
			String reverse = reverseString(asf);
			if(oddc != null) {
				System.out.println(asf + oddc + reverse);
			}
			else {
				System.out.println(asf  + reverse);
			}
			return;
		}
		for(char ch : fmap.keySet()) {
		    
			int freq = fmap.get(ch);
			if(freq > 0) {
				fmap.put(ch, freq-1);
				generatepw(cs + 1, ts, fmap, oddc, asf + ch);
				fmap.put(ch, freq);
			}
		}
	}
	public static String reverseString(String str) {
		String res = "";
		for(int i = str.length()-1; i >= 0; i--) {
			res += str.charAt(i);
		}
		return res;
	}
	public static void solve(HashMap<Character, Integer> fmap) {
	    
		int oddCount = 0;
		Character oddc = null;
		int totLen = 0;
		for(char ch : fmap.keySet()) {
			int freq = fmap.get(ch);
			totLen += freq;
			if(freq % 2 == 1) {
				oddCount++;
				oddc = ch;
			}
			fmap.put(ch, freq/2);
		}
		if(oddCount > 1) {
			System.out.println(-1);
			return;
		}
		generatepw(0, totLen/2, fmap, oddc, "");
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		//write your code here
		solve(fmap);
	}
	
}