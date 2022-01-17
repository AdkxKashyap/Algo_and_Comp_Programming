class Solution {
  public int findMaxLength(int[] arr) {
  HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);
  int maxIdx = 0;
  int sum = 0;
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == 0)
      sum += -1;
    else
      sum += 1;

    if(map.containsKey(sum)) {
      maxIdx = Math.max(maxIdx, i-map.get(sum));
    } else {
      map.put(sum, i);
    }
  }
  return maxIdx;
  }
}