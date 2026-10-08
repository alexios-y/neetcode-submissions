class KthLargest {
    private int kth;
    private PriorityQueue<Integer> q;


    public KthLargest(int k, int[] nums) {
        this.kth=k;
        this.q=new PriorityQueue<Integer>();
        for(int n:nums){
            q.offer(n);
            if(q.size()>kth){
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
            if(q.size()>kth){
                q.poll();
            }
            return q.peek();
    }
}
