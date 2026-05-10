class MinStack {
Stack<Integer> st;
Stack<Integer> m;
int min;

    public MinStack() {
     this.st= new Stack<>();
     this.m= new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
      if(m.isEmpty()){
        min=val;
        }
        else if (!st.isEmpty()){
         min= Math.min(m.peek(), val);
        }
         m.push(min);


        
    }
    
    public void pop() {
        st.pop();
        m.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return m.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */