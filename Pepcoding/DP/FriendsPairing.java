package DP;

import java.io.*;
import java.util.*;

public class FriendsPairing {
    //for tabular and recc see notes and video
    public static int count(int n) {
        int a = 1;
        int b = 1;
        for(int i = 1; i <= n; i++) {
            int tmp = a;
            a = b;
            b = b + (i - 1) * tmp; 
        }
        return b;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = count(n);
        System.out.println(res);
    }

}
