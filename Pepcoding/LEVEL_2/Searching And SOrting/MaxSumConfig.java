import java.util.*;

public class MaxSumConfig {

    public static int maximise(int[]arr) {
        //write your code here
        int sum = 0;
        int S0 = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            S0 += arr[i]*i;
        }
        int max = 0;
        int Si = S0;
        for(int i = 0; i < n; i++) {
            int tmp = Si + sum - (n * arr[n-1-i]);
            max = Math.max(max, tmp);
            Si = tmp;
        }
        return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}