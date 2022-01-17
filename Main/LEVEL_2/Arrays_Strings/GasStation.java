package Main.LEVEL_2.Arrays_Strings;
public class GasStation {
  //LC 134, FOR PROOF SEE PEPCODING VIDEO
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int gassum = 0;
    int costsum = 0;
    for(int i = 0; i < n; i++) {
        gassum+=gas[i];
        costsum+=cost[i];
    }
    if(gassum - costsum < 0) return -1;
    int indx = 0;
    int min = Integer.MAX_VALUE;
    int prefix = 0;
    
    for(int i = 0; i < n; i++) {
        prefix+= gas[i]-cost[i];
        if(prefix<min) {
            min = prefix;
            indx = i;
        }
    }
    return (indx+1)%n;
  }
}
