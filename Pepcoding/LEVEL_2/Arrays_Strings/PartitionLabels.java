class PartitionLabels {
  public List<Integer> partitionLabels(String s) {
      HashMap<Character, Integer> hmap = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          hmap.put(ch, i);
      }
      //solve using chaining technique
      List<Integer> res = new ArrayList<>();
      int prev = 0;
      int max = 0;
      for(int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          max = Math.max(hmap.get(ch), max);
          if(max == i) {
              res.add(i-prev+1);
              prev = i+1;
          }
      }
      return res;
  }
}