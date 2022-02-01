//https://leetcode.com/problems/minimum-moves-to-reach-target-score/
public class MinMovesToReachTargetScore {
  public int minMoves(int target, int maxDoubles) {
    int k = maxDoubles;
    int t = target;
    int steps = 0;
    while(t > 1 && k > 0) {
        int rem = t%2;
        t = t/2;
        steps = steps+1+rem;
        k--;
    }
    if(t > 0) {
        steps += (t-1);
    }
    return steps;
}
}
