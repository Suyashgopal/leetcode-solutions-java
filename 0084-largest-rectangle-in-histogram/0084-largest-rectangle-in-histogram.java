class Solution {
    public int largestRectangleArea(int[] h) {
        
        int n= h.length;
        
        //right
        Stack<Integer> st= new Stack<>();
        int i=n-1;
        int [] right = new int[n];
        while(i>=0){
            while(!st.isEmpty() && h[st.peek()]>=h[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]= n-i;
                st.push(i);
            }
            else if(!st.isEmpty() && h[st.peek()]<h[i]){
               
                right[i]=st.peek()-i;
                 st.push(i);

            }
            i--;


        }


        //left
            Stack<Integer> st1= new Stack<>();
         i=0;
        int [] left = new int[n];

        while(i<n){
            while(!st1.isEmpty() && h[st1.peek()]>=h[i]){
                st1.pop();
            }
             if(st1.isEmpty()){
                left[i]= i;
                st1.push(i);
            }
            else if (!st1.isEmpty()&& h[st1.peek()]< h[i]){
                left[i]= i-st1.peek()-1;
                st1.push(i);
            }
            i++;



        }


        //caculalate max 
        int max=0;
        for(int j=0;j<n;j++){
            int c= h[j]* (left[j] + right[j]);
            max= Math.max(max,c);

        }

 return max;

    }

}