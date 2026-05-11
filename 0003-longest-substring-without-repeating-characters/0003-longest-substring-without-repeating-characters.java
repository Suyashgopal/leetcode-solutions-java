class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        char[] c= s.toCharArray();
        int max=0;
   int i=0;
   int j=0;
   int n= c.length;
  

   while(j<n){
    while(set.contains(c[j])){
        set.remove(c[i]);
        i++;

    }
    set.add(c[j]);
    max= Math.max(j-i+1,max);
    j++;
   }

  return max;

    }
}