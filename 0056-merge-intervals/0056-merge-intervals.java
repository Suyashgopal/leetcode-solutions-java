import java.util.*;


class Solution {
    public int[][] merge(int[][] m) {
        int r= m.length;
        if(r==1){
            return m;

        }
        pairs[] p= new pairs[r];
        for(int i=0;i<r;i++){
            p[i]= new pairs(m[i][0],m[i][1]);
        }
        Arrays.sort(p);
        //merging
        Stack<pairs> st= new Stack<>();
        st.push(p[0]);
        for(int i=0;i<r;i++){
            pairs top= st.peek();

            if(p[i].st>top.et){
                st.push(p[i]);
            }
            else{
                top.et= Math.max(p[i].et,top.et);
            }
        }

       int[][] res= new int[st.size()][2];
        for(int i=st.size()-1;i>=0;i--){
            pairs k= st.pop();
            
            res[i][0]= k.st;
            res[i][1]= k.et;
        }

   return res;


    }
    class pairs implements Comparable<pairs>{
        int st;
        int et;
        pairs(int st,int et){
            this.st=st;
            this.et=et;

        }


        @Override
        public int compareTo(pairs o) {
          if(this.st!=o.st){
              return this.st-o.st;
          }
          else{
              return this.et-o.et;
          }
        }
    }

}