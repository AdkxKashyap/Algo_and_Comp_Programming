package Main.Arrays_Funcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateAnArray {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
      }
    
      public static void rotate(int[] a, int k){
        // write your code here
        int n=a.length;
        
        //bring k to range and make it positive if k<0
         k= k<0?k%n+n:k%n;
         int l;
         int r;
         //reverse from 0 to n-k-1
         r=n-k-1;
         l=0;
         while(l<r){
           a[l]=a[l]+a[r];
           a[r]=a[l]-a[r];
           a[l]=a[l]-a[r];

           l++;
           r--;
         }
          //reverse from n-k to n-1
          r=n-1;
          l=n-k;
          while(l<r){
            a[l]=a[l]+a[r];
            a[r]=a[l]-a[r];
            a[l]=a[l]-a[r];
 
            l++;
            r--;
          }

          //reverse whole arr
          r=n-1;
          l=0;
          while(l<r){
            a[l]=a[l]+a[r];
            a[r]=a[l]-a[r];
            a[l]=a[l]-a[r];
 
            l++;
            r--;
          }
         
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        rotate(a, k);
        display(a);
     }
}
