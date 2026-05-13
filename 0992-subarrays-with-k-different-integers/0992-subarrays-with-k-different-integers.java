class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {


         return findans(arr,k)- findans(arr,k-1);


                

        
    }
    public int findans(int [] arr, int k){


        if(k==-1){
            return 0;

        }
        int n= arr.length;
        int count =0;

                        HashMap<Integer, Integer> m = new HashMap<>();
                        int i=0;
                        int j=0;
                        while(j<n){
                            m.put(arr[j],m.getOrDefault(arr[j],0)+1);
                            while(m.size()>k){
                                int rem= arr[i];
                                m.put(arr[i],m.get(arr[i])-1);
                                if(m.get(rem)==0){
                                    m.remove(rem);

                                }
                                i++;

                            }
                            count= count+(j-i+1);
                            j++;

                        }
                        return count;


    }
}






        