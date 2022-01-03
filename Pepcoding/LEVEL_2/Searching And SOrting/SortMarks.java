import java.util.*;
import java.io.*;

public class Main {
    public static class Marks implements Comparable<Marks> {
      int phy = 0;
      int chem = 0;
      int maths = 0;
      Marks(int phy, int chem, int maths) {
        this.phy = phy;
        this.chem = chem;
        this.maths = maths;
      }
      @Override
      public int compareTo(Main.Marks o) {
        // TODO Auto-generated method stub
        if(this.phy != o.phy) {
          return this.phy - o.phy;
        } else if(this.chem != o.chem) return o.chem - this.chem;
        else return this.maths - o.maths;
        return 0;
      }
      
    }
    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        Marks[] arr = new Marks[phy.length];
        for(int i = 0; i < phy.length; i++) {
          arr[i] = new Marks(phy[i], chem[i], math[i]);
        }
        Arrays.sort(arr);
        //place res in respective arrays
        for(int i = 0; i < phy.length; i++) {
          phy[i] = arr[i].phy;
          chem[i] = arr[i].chem;
          math[i] = arr[i].maths;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}