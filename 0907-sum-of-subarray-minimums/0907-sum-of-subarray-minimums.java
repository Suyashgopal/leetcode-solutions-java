class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD= 1000000007;
        Stack<Integer> st= new Stack<>();
                Stack<Integer> st1= new Stack<>();


        int n= arr.length;

       //left to right
    int i=0;
    int [] left= new int[n];
    while(i<n){
        while(!st.isEmpty() && arr[st.peek()]> arr[i]){
            st.pop();
        }
        if(st.isEmpty()){
        left[i]=i+1;
        st.push(i);
        }
        else if(!st.isEmpty() && arr[st.peek()]<=arr[i]){
            left[i]= i-st.peek();
            st.push(i);
        }
        i++;
    }

      
       //right to left 

       int j=n-1;
       int k= n-1; 
    int [] right= new int[n];
    while(j>=0){
        while(!st1.isEmpty() && arr[st1.peek()]>= arr[j]){
            st1.pop();
        }
        if(st1.isEmpty()){
        right[j]=n-j;
        st1.push(j);
        }
        else if(!st.isEmpty() && arr[st1.peek()]<=arr[j]){
            right[j]= st1.peek()-j;
            st1.push(j);
        }
        j--;
    }

      
    //calculate sum

    long sum=0;
    for(int s=0;s<n;s++){
        long part = (long)arr[s] * left[s] * right[s];
        sum= sum + part;
        sum= sum% MOD;
    }
   return (int)sum%MOD;

    }
}