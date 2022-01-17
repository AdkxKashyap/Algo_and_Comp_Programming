package Main.LEVEL_2.Stacks;
class CustomStack {
  int[] stk;
  int[] incr;
  int idx ;
  public CustomStack(int maxSize) {
      idx = -1;
      stk = new int[maxSize];
      incr = new int[maxSize];
  }
  
  public void push(int x) {
      if(idx+1 == stk.length) return;
      idx++;
      stk[idx] = x;
      //this is reqd to reset inc value
      incr[idx] = 0;
  }
  
  public int pop() {
      if(idx < 0) {
        return -1;
      }
      int val = stk[idx];
      int inc = incr[idx];
      idx--;
      //pass on inc val to next in stk
      if(idx > -1) {
        incr[idx] += inc;
      }
      return val+inc;
  }
  
  public void increment(int k, int val) {
    /**suppose k = 2 we need to increment idx 0 and 1. So mark k-1 element. 
     * if k > idx incr all elements**/
      int i = Math.min(k-1, idx);
      if(idx >= 0)
        incr[i] += val;
  }
}

/**
* Your CustomStack object will be instantiated and called as such:
* CustomStack obj = new CustomStack(maxSize);
* obj.push(x);
* int param_2 = obj.pop();
* obj.increment(k,val);
*/