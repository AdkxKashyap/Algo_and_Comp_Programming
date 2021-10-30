package Arrays_Funcs;

import java.util.Scanner;
//Subreact elements of a2 from a1
public class DiffOfArray {
    static Scanner scanner = new Scanner(System.in);

    public static void takeInput(int[]arr,int n){
        for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        int n1=scanner.nextInt();
        int[] a1=new int[n1];
        takeInput(a1,n1);

        int n2=scanner.nextInt();
        int[] a2=new int[n2];
        takeInput(a2,n2);


        int[] res=findDiff(a1,a2,n1,n2);
        display(res);
    }
    public static void display(int[] arr){
        
        int i;
        //do not print leading 0
        for(i=0;i<arr.length;i++){
            if(arr[i]>0)break;
        }
        //print
        for(;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] findDiff(int[] a1,int[] a2,int n1,int n2){
        int resLen=Math.max(n1,n2);
        int[] res=new int[resLen];
        int k=resLen-1;
        int i=n1-1;
        int j=n2-1;
        int carry=0;
        while(k>=0){
            int val1=i<0?0:a1[i],val2=a2[j];
            
            int sub=carry+val2-val1;
            if(sub<0){
                sub=sub+10;
                carry=-1;
            }
            else carry=0;
            res[k]=sub;
            i--;
            j--;
            k--;
        }
        
        return res;
    }
}
