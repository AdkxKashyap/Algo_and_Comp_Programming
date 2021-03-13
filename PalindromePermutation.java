import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//Question and practice-https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/all-palindromic-permutations-official/ojquestion
//explain--https://www.youtube.com/watch?v=DwdWafLsGm0
//see permutaion strings from pepcoding
//see permutation 1 and 2
public class PalindromePermutation {
    public static void generatepw(int currSlot, int totalSlots, HashMap<Character, Integer> fmap, Character oddc, String resStr) {
		if(currSlot>totalSlots){
            String reverseStr="";
            for(int i=resStr.length()-1;i>-1;i--){
                reverseStr+=resStr.charAt(i);
            }
            if(oddc!=null)resStr+=oddc;
            resStr+=reverseStr;
            System.out.println(resStr);
            return;
        }
        for(char ch:fmap.keySet()){
            int freq=fmap.get(ch);
            if(freq>0){
                fmap.put(ch, freq-1);
                generatepw(currSlot+1, totalSlots, fmap, oddc, resStr+ch);
                fmap.put(ch, freq);
            }
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		Character oddch=null;
        int odds=0,len=0;
        for(char ch:fmap.keySet()){
            int freq=fmap.get(ch);
            if(freq%2==1){
                oddch=ch;
                odds++;
            }
            fmap.put(ch, freq/2);
            len+=freq/2;
        }
        //if there are more than 1 odds than no palidrome is possible
        if(odds>1){
            System.out.println(-1) ; 
            return;
        }
        generatepw(1, len, fmap, oddch, "");
	}
}
