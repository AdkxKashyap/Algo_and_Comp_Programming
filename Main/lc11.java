package Main;
public class lc11 {
   //https://leetcode.com/problems/container-with-most-water/ 
   public int maxArea(int[] height) {
        int largest=0,secondLargest=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>=height[secondLargest]){
                if(height[i]>height[largest]){
                    secondLargest=largest;
                    largest=i;
                }
                else{
                    secondLargest=i;
                }
            }
        }
        System.out.println(largest+" "+secondLargest);
        // return (largest>secondLargest?height[secondLargest]*(largest-secondLargest):height[secondLargest]*(secondLargest-largest));
        if()
}
public static void main(String[] args) {
    int[] height={1,8,6,2,5,4,3,2,7};
    new lc11().maxArea(height);
}
}
