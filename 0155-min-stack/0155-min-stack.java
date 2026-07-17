class MinStack {
    int[] stack;
    int[] minStack;
    int top;
    int minTop;
    

    public MinStack() {
        stack=new int[100000];
        minStack=new int[100000];
        top=-1;
        minTop=-1;
        
    }
    
    public void push(int value) {
        top++;
        stack[top]=value;
        if(minTop == -1 || value<=minStack[minTop]){
            minTop++;
            minStack[minTop]=value;
            
        }else{
            minTop++;
            minStack[minTop]=minStack[minTop-1];
        }
        
    }
    
    public void pop() {
        if(top==-1){
            System.out.println("stack is empty");
            return;
        }
        top--;
        minTop--;
        
    }
    
    public int top() {
        if(top==-1){
            System.out.println("stack is empty");
            return -1;
        }
        return stack[top];
        
    }
    
    public int getMin() {
        if(minTop==-1){
            System.out.println("stack is empty");
            return -1;
            
        }
        return minStack[minTop];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */