import java.util.Scanner;

public class DisplayArray {
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx==arr.length)return;
        System.out.println(arr[idx]);
        displayArr(arr,++idx);
    }
}
