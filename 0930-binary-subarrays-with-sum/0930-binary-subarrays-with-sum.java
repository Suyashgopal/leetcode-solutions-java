class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subarray(nums, goal)- subarray(nums,goal-1);
        
    }
    int subarray(int [] arr , int g){
        int i=0;
        int j=0;
        int n= arr.length;
        int sum=0;
        int sub=0;
        while(j<n){
            sum = sum+arr[j];
            while(i<=j && sum>g ){
                sum= sum-arr[i];
                i++;
            }
            if(sum<=g){
                sub= sub+ (j-i)+1;

            }

            j++;

        }
        return sub;
    }
}