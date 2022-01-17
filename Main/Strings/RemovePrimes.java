package Main.Strings;
import java.io.*;
import java.util.*;

public class RemovePrimes {
    public static void solution(ArrayList<Integer> al){
		// write your code here
		for(int i=al.size()-1;i>=0;i--){
            int n=al.get(i);
            if(isPrime(n))al.remove(i);
        }
	}
    public static boolean isPrime(int n){
        //remove from last
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}
}
