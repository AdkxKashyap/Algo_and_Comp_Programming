public class ContainerWithMaxWater {
  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int maxWater = 0;
    while(i < j) {
        int l = j-i;//length
        int ht = Math.min(height[i], height[j]);
        int water = ht * l;
        maxWater = Math.max(maxWater, water);
        if(height[i] < height[j]) {
            i++;
        }else j--;
    }
    return maxWater;
}
}
