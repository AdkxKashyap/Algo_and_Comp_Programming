import java.util.Scanner;

public class RelativelyPrimePairs {
    //https://codeforces.com/problemset/problem/1051/B

    public void getPairs(int l,int r){
        if(l>=r){System.out.println("NO"); return;}
        int size=((r-l)+1)/2;
        int start=l;
        System.out.println("YES");
        for(int i=0;i<size;i++){
            System.out.println(start+" "+(start+1));
            start+=2;
        }
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int l=scn.nextInt();
        int r=scn.nextInt();
        new RelativelyPrimePairs().getPairs(l, r);
    }
}
