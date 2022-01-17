import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        //level - box, options - yes/No
        if(tq == row) {
            if(qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }
        String yesStr = "";
        String noStr = "";
        if(col == tq-1) {
            row = row+1;
            col = 0;
            yesStr = asf + "q\n";
            noStr = asf + "-\n";
        } else {
            col++;
            yesStr = asf + "q";
            noStr = asf + "-";
        }
        //yes call
        queensCombinations(qpsf+1, tq, row, col, yesStr);
        //no call
        queensCombinations(qpsf, tq, row, col, noStr);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}