class Solution {
    public String removeKdigits(String num, int k) {
        
      

      Stack<Integer> st= new Stack<>();
      char[] c= num.toCharArray();
      int i=0;
      int n= c.length;
      if(k==n){
        return "0";
      }
      int rem=k;
      while(i<n){

       int v= c[i]-'0';
        while(!st.isEmpty() && v<st.peek() && k>0){
            st.pop();
            k--;
        }

       
            st.push(v);
        i++;
      }
       while(k>0){
        st.pop();
        k--;}

        char[] res= new char[n-rem];
        int ptr= res.length-1;
        while(ptr>=0){
            char o=(char)(st.pop()+'0');
            res[ptr]=o;
            ptr--;
        }
        int start=0;

    while (start < res.length && res[start] == '0') {
            start++;
        }

        if (start == res.length) {
            return "0";
        }

     
     String g= new String (res);
     return g.substring(start); 

    }
}