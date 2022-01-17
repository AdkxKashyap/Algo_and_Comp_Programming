package Main;
import java.util.*;
  
  public class TheCuriousCaseOfBenjaminBulbs{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner scanner = new Scanner(System.in);
    int n=scanner.nextInt();
    for(int i=1;i*i<=n;i++)System.out.println(i*i);
   }
  }