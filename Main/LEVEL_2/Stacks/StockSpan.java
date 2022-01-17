package Main.LEVEL_2.Stacks;
import java.io.*;
import java.util.*;

public class Main {

    static class StockSpanner {

        static class Pair{
            int stock;
            int index;
            Pair(int price, int idx) {
                stock = price;
                index = idx;
            }
        }
        public Stack<Pair> stk ;
        public int idx ;
        public StockSpanner() {
            stk = new Stack<>();
            idx = 0;
            stk.push(new Pair(Integer.MAX_VALUE, -1));
        }
        
        public int next(int price) {
            Pair p = new Pair(price, idx++);
            int res = 0;
           
                while(price >= stk.peek().stock) {
                    stk.pop();
                }
                res =  p.index - stk.peek().index;
                stk.push(p);
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StockSpanner obj = new StockSpanner();

        while(read.ready()){
            int price = Integer.parseInt(read.readLine());
            System.out.println(obj.next(price));
        }        
    }
}
