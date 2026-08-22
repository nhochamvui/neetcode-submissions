class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> sub; 
    public MinStack() {
        this.stack = new ArrayDeque<Integer>();
        this.sub = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(sub.isEmpty() || val <= sub.peek()){
            this.sub.push(val);
        }
    }
    // -100, -200, -300, -400
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        if(!sub.isEmpty() && top == sub.peek()){
            this.sub.pop();
        }
        // this.stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return sub.peek();
    }
}
