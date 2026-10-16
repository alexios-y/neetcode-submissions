class MinStack {

    // static class Node{
    //     private int val;
    //     private Node next;
    //     private Node prev;

    //     Node(int val){
    //         this.val=val;
    //     }
    // }

    // int min=Integer.MAX_VALUE;
    // Node tail;
    // int count=0;
    // Map<Integer, Integer> map;
    // public MinStack() {
    //     map=new HashMap<>();
    // }
    
    // public void push(int val) {
    //     if(tail==null){
    //         tail=new Node(val);
    //         count++;
    //         map.put(count, val);
    //     } else{
    //         Node n=new Node(val);
    //         tail.next=n;
    //         n.prev=tail;
    //         tail=n;
    //         int curMin=map.get(count);
    //         map.put(++count, Math.min(curMin,val));
    //     }
    // }
    
    // public void pop() {
    //     Node n=tail.prev;
    //     if(n!=null){
    //         n.next=null;
    //         tail.prev=null;
    //     }
    //     tail=n;
    //     map.remove(count);
    //     count--;
    // }
    
    // public int top() {
    //     return tail.val;
    // }
    
    // public int getMin() {
    //     return map.get(count);
    // }

    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    void push(int val){
        stack.push(val);
        if(!minStack.empty()){
            minStack.push(Math.min(val, minStack.peek()));
        } else{
            minStack.push(val);
        }
    }

    void pop(){
        stack.pop();
        minStack.pop();
    }

    int top(){
        return stack.peek();
    }

    int getMin(){
        return minStack.peek();
    }
}
