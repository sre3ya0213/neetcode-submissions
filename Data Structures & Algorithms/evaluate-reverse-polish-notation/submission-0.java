class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> store = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
                switch (tokens[i]) {
                    case "+":
                        if(!store.isEmpty()) {
                            int val1 = store.pop();
                            int val2 = store.pop();
                            store.push(val2 + val1);
                        }
                        break;
                    case "-":
                        if(!store.isEmpty()) {
                            int val1 = store.pop();
                            int val2 = store.pop();
                            store.push(val2 - val1);
                        }
                        break;
                    case "*":
                        if(!store.isEmpty()) {
                            int val1 = store.pop();
                            int val2 = store.pop();
                            store.push(val2 * val1);
                        }
                        break;
                    case "/":
                        if(!store.isEmpty()) {
                            int val1 = store.pop();
                            int val2 = store.pop();
                            store.push(val2 / val1);
                        }
                        break;
                    default:
                      store.push(Integer.valueOf(tokens[i]));
                }
        }

        return store.peek();
    }
}
