package Main.Recurssion;
class PrintZigzag{
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        pzz(n);
    }

    public static void pzz(int n){
        if(n==0)return;
        System.out.println(n);
        pzz(n-1);
        System.out.println(n);
        pzz(n-1);
        System.out.println(n);
    }
}