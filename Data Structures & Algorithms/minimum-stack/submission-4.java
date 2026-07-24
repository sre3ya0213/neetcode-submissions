class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> store;

    public MinStack() {
        stack = new Stack<>();
        store = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(store.isEmpty())
        {
            store.push(val);
        }
        else {
         store.push(Math.min(val,store.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        store.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return store.peek();
    }
}
