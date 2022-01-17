package Main.LEVEL_2.Graph;
public class SatisfiabilityOfEqualityEquation {
  public int find(int[] par, int e) {
    if (par[e] == e)
      return e;
    int tmp = find(par, par[e]);
    par[e] = tmp;
    return tmp;
  }

  public void union(int[] par, int[] rank, int lx, int ly) {
    if (rank[lx] > rank[ly]) {
      par[ly] = lx;
    } else if (rank[lx] < rank[ly]) {
      par[lx] = ly;
    } else {
      par[ly] = lx;
      rank[lx]++;
    }
  }

  public boolean equationsPossible(String[] equations) {
    int[] par = new int[26];
    int[] rank = new int[26];
    for(int i = 0; i < 26; i++) {
      par[i] = i;
      rank[i] = 1;
    }
    for (int i = 0; i < equations.length; i++) {
      if (equations[i].charAt(1) == '=') {
        int x = equations[i].charAt(0) - 'a';
        int y = equations[i].charAt(3) - 'a';
        int lx = find(par, x);
        int ly = find(par, y);
        if (lx != ly) {
          union(par, rank, lx, ly);
        }
      }
    }
    for (int i = 0; i < equations.length; i++) {
      if (equations[i].charAt(1) == '!') {
        int x = equations[i].charAt(0) - 'a';
        int y = equations[i].charAt(3) - 'a';
        int lx = find(par, x);
        int ly = find(par, y);
        if(lx == ly) return false;
      }
    }
    return true;
  }
}
