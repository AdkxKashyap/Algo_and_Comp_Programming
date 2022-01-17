package Main.LEVEL_2.Arrays_Strings;
class Solution {
  public void solver(char[] arr, int i, int j) {
          if(arr[j] == 'L' && arr[i] == 'L') {
              i++;
              while(i < j) {
                  arr[i] = 'L';
                  i++;
              }
          }else if(arr[i] == 'R' && arr[j] == 'R') {
              i++;
              while(i < j) {
                  arr[i] = 'R';
                  i++;
              }
           }
          //else if(arr[j] == 'R' && arr[i] == 'L') {
          //     //do nothing
          // }
          else if(arr[i] == 'R' && arr[j] == 'L') {
              i++;
              j--;
              while(i<j) {
                  arr[i] = 'R';
                  arr[j] = 'L';
                  i++;
                  j--;
              }
          }
  }
  public String pushDominoes(String dominoes) {
      char[] arr = new char[dominoes.length()+2];
      arr[0] = 'L';
      arr[arr.length-1] = 'R';
      for(int i = 1; i <= dominoes.length(); i++) {
          arr[i] = dominoes.charAt(i-1);
      }
      int i = 0;
      int j = 1;
      while(j < arr.length) {
          while(arr[j] == '.') {
              j++;
          }
          if(j-i > 1) {
              solver(arr, i, j);
          }
          i = j;
          j++;
      }
      StringBuilder sb = new StringBuilder();
      for(int k = 1; k < arr.length-1; k++) {
          sb.append(arr[k]);
      }
      return sb.toString();
  }
}