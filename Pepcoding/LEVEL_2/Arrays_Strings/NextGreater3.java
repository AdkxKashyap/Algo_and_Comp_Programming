//lc - 556
class NextGreater3 {
  public int nextGreaterElement(int n) {
      String str = Integer.toString(n);
      char[] arr = str.toCharArray();
      int i = 0;
      for(i = arr.length - 2; i >= 0; i--) {
          if(arr[i] < arr[i+1]) break;
      }
      if(i == -1) return -1;
      //search for elem just greater than arr[i]
      int k = arr.length - 1;
      while(k > i) {
          if(arr[k] > arr[i]) break;
          k--;
      }
      //swap
      char tmp = arr[i];
      arr[i] = arr[k];
      arr[k] = tmp;
      
      String res = "";
      for(int j = 0; j <= i; j++) {
          res += arr[j];
      }
      k = arr.length-1;
      while(k > i) {
          res += arr[k];
          k--;
      }
      long val = Long.parseLong(res);
      return val <= Integer.MAX_VALUE ? (int)val : -1;
  }
}