/**Basic Explaination-https://www.youtube.com/watch?v=quAS1iydq7U&t=605s
 * code-https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia
 * how permutation works-->check permutation1
 * see copy
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int i,j;
        for(i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1])break;
        }
        if(i<0){reverse(nums,0,nums.length-1); 
        }
        else{
            for(j=len-1;j>i;j--){
                if(nums[i]<nums[j]){
                    swap(nums, i, j);
                    reverse(nums, i+1,nums.length-1);
                    break;
                }
            }
        } 
    }
    void reverse(int[] nums, int s, int e){
        while(s < e){
          swap(nums, s, e);
          s++;
          e--;
        }
      }
    void swap(int[] arr,int start,int end){
        arr[start]=arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
    public static void main(String[] args) {
        int[] arr={1,3,2};
        new NextPermutation().nextPermutation(arr);
        for(int i:arr)System.out.println(i);
    }
}
