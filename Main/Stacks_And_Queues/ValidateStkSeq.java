package Main.Stacks_And_Queues;

import java.io.*;
import java.util.*;
//https://
//leetcode.com/problems/validate-stack-sequences/
//solution->https://www.geeksforgeeks.org/stack-permutations-check-if-an-array-is-stack-permutation-of-other/
public class ValidateStkSeq {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        Queue<Integer> inQueue = new ArrayDeque<>();
        Queue<Integer> outQueue = new ArrayDeque<>();
        for(int i:arr1){
            inQueue.add(i);
        }
        for(int i:arr2){
            outQueue.add(i);
        }
        Stack<Integer> stk = new Stack<>();
        while(inQueue.size() != 0 && outQueue.size() != 0){
            int in = inQueue.poll();
            if(in != outQueue.peek()){
                stk.push(in);
            }
            else{
                outQueue.poll();
                while(stk.size() != 0 && outQueue.size() != 0 && outQueue.peek() == stk.peek()){
                    outQueue.poll();
                    stk.pop();
                }
            }
        }
        
        if(stk.size() == 0 && outQueue.size() == 0)System.out.println(true);
        else{
          System.out.println(false); 
        }
        
        
    }
}