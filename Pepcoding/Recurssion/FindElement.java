import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int x=scanner.nextInt();
        firstIndex(arr, 0, x);
    }
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length)return -1;
        if(arr[idx]==x)return idx;
        return firstIndex(arr, ++idx, x);
    }
}
