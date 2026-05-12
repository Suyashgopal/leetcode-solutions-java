class Solution {
    public int numberOfSubstrings(String s) {
        char[] c= s.toCharArray();

        int n= c.length;
        long total= ((long)n*(n+1))/2;
        HashMap<Character ,Integer> map= new HashMap<>();
        int i=0;
        int j=0;
        long sub =0;
        while(j<n){
             map.put(c[j], map.getOrDefault(c[j],0)+1);

            while(i<j && map.size()>2){
               
                map.put(c[i], map.get(c[i])-1);
                 if(map.get(c[i])==0){
                    map.remove(c[i]);
                }         
                        i++;


            }
            if(map.size()<=2){
                sub = sub+j-i+1;
            }
         
         j++;
        }
        return(int ) (total-sub);

 



    }
}