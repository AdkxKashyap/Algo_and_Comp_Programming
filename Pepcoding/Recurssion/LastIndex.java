import java.util.Scanner;


    public class LastIndex {
        public static void main(String[] args) throws Exception {
            // write your code here
            Scanner scanner = new Scanner(System.in);
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int x=scanner.nextInt();
            lastIndex(arr, 0, x);
        }
        public static int lastIndex(int[] arr, int idx, int x){
            int index=-1;
            if(idx==arr.length)return index;
            if(arr[idx]==x)index=idx;
            return  Math.max(index,lastIndex(arr, ++idx, x));
        }
    }

