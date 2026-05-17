class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map= new HashMap<>();
                int i=0;
                int j=0;
                int n= s.length();
                int minl= Integer.MAX_VALUE;
                int start=0;
                int req=t.length();



                for(int k=0;k<t.length();k++){
                    char c= t.charAt(k);
            map.put(c, map.getOrDefault(c, 0) + 1);
            }

    
                    while(j<n){
                    char ch= s.charAt(j);
                    if(map.containsKey(ch)){
                        if(map.get(ch)>0){
                            req--;
                        }
                        map.put(ch, map.get(ch)-1);
                    }
                    while (req==0){
                      
                        if(j-i+1<minl){
                            start=i;
                            minl= j-i+1;
                        }

                        char c2= s.charAt(i);
                        if(map.containsKey(c2)){
                            map.put(c2, map.get(c2)+1);
                            if(map.get(c2)>0){
                                req++;
                            }
                        }
                        i++;
           }j++;
                    }

                    if(minl== Integer.MAX_VALUE){
                        return "";
                    }
                    
                    return s.substring(start,start+ minl);  
                    
                    
                    
                    
                    }}