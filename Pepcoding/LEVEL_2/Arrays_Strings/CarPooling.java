public class CarPooling {
  public boolean carPooling(int[][] trips, int capacity) {
        int len = 0;//tot length of trip
        int[] arr = new int[1001];
        /** 0-passengers
         * 1 - pickup(start)
         * 2 - drop(end)
          */
          for(int i = 0; i < trips.length; i++) {
            int pass = trips[i][0];
            int pickup = trips[i][1];
            int drop = trips[i][2];
            arr[pickup] = pass;//add pass
            arr[drop] = -pass;//drop pass

            len = Math.max(len, drop);
          }
          int prefixSum = 0;
          for(int k = 0; k < len; k++) {
            prefixSum+=arr[k];
            if(prefixSum > capacity) return false;
          }
          return true;
  }
}
