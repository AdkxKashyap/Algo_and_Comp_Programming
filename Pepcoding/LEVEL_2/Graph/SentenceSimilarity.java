import java.io.*;
import java.util.*;

public class SentenceSimilarity {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }

  public static String find(String str, HashMap<String, String> par, HashMap<String, Integer> rank) {
    if (par.containsKey(str) == false) {
      par.put(str, str);
      rank.put(str, 1);
    }
    if (par.get(str).equals(str))
      return str;
    String tmp = find(par.get(str), par, rank);
    par.put(str, tmp);
    return tmp;
  }

  public static void union(String x, String y, HashMap<String, String> par, HashMap<String, Integer> rank) {
    String lx = find(x, par, rank);
    String ly = find(y, par, rank);
    if (lx.equals(ly) == false) {
      if (rank.get(lx) > rank.get(ly)) {
        par.put(lx, ly);
      } else if (rank.get(lx) < rank.get(ly)) {
        par.put(ly, lx);
      } else {
        par.put(ly, lx);
        rank.put(lx, rank.get(lx) + 1);
      }

    }
  }

  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
    HashMap<String, String> par = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();
    if(Sentence1.length != Sentence2.length) return false;
    for(int i = 0; i < pairs.length; i++) {
      union(pairs[i][0], pairs[i][1], par, rank);
    }
    for(int i = 0; i < Sentence1.length; i++) {
      String x = Sentence1[i];
      String y = Sentence2[i];
      if(x.equals(y) == false && find(x, par, rank).equals(find(y, par, rank)) == false) return false;
    }
    return true;
  }

}
