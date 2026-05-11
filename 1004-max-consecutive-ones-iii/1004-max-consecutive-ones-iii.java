class Solution {

    public int longestOnes(int[] n, int k) {
        int i=0;
        int j=0;
        int ctr=k;
        int max=0;
        int sum=0;
        while(j<n.length){
        if(n[j]==1){
            j++;
            sum++;
        }
        else if(n[j]==0 && ctr>0){
            j++;
            sum++;
            ctr--;
        }
            else if(n[j]==0 && ctr==0){
              while(n[i]!= 0){
                i++;
                sum--;
              }
              i++;
              sum--;
              ctr++;
            }
            max=Math.max(sum,max);
            
        }
        return max;
        
    }
}