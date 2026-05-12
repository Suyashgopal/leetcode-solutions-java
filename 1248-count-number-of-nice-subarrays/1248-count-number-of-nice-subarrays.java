class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subarray(nums, k)- subarray(nums,k-1);
        
    }


      int subarray(int [] arr , int g){
        int i=0;
        int j=0;
        int n= arr.length;
        int oddcount=0;
        int sub=0;
        while(j<n){
            if(arr[j]%2!= 0){
                oddcount++;
            }


            while(i<=j && oddcount>g ){
                 if(arr[i]%2!= 0){
                oddcount= oddcount-1;
            }

                i++;
            }
            if(oddcount<=g){
                sub= sub+ (j-i)+1;

            }

            j++;

        }
        return sub;
    }
}



