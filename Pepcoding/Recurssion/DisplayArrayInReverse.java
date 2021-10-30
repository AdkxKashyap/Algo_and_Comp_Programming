import java.util.Scanner;

public class DisplayArrayInReverse {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        displayArr(arr, n-1);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx<0)return;
        System.out.println(arr[idx]);
        displayArr(arr,--idx);
    }
}
