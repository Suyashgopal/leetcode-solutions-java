class Solution {
    public int totalFruit(int[] arr) {
       HashMap<Integer,Integer> map= new HashMap<>();
    int i=0;
    int j=0;
    int  n= arr.length;
    int max =0;
    while(j<n){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
 
   
    while(map.size()>2){
        map.put(arr[i], map.getOrDefault(arr[i],0)-1);
         if (map.get(arr[i]) == 0) 
         {
            map.remove(arr[i]);}
 i++;

    }



       
        
    
    
    max= Math.max(max,j-i+1);

    j++;
    }
    return max;
    }
}