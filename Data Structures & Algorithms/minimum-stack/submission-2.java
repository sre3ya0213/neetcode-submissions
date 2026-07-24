class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> store;

    public MinStack() {
        stack = new Stack<>(); 
        store = new Stack<>();
    }
    
    public void push(int val) {
       if(store.isEmpty() || store.peek() >= val)
       {
          store.push(val);
       }
       stack.push(val);   
    }
    
    public void pop() {
       if (stack.isEmpty()) return;
       if(stack.peek().equals(store.peek()))
       {
         store.pop();
       }
       stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return store.peek();
    }
}
