package Main.Recurssion;
import java.util.Scanner;

public class MaxElement {
   public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        maxOfArray(arr, 0);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length)return 0;
        return Math.max(arr[idx], maxOfArray(arr,++idx));   

    }
}
