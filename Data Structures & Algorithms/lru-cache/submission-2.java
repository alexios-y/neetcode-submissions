class LRUCache {
    static class Node{
        private int key, val;
        private Node prev;
        private Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }

    private int size=0;
    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map = new HashMap<>(capacity);
    }
    
    private void add(Node n){
        if(tail==null){
            head=tail=n;
        } else{
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
        size++;
    }

    private void remove(Node n){
        if(head==null){
            return;
        }

        if(head==n && tail ==n){
            head = tail =null;
        } else if(head==n){
            n.next.prev=null;
            head=n.next;
            n.next=null;
        } else if(tail==n){
            n.prev.next=null;
            tail=n.prev;
            n.prev=null;
        } else{
            n.prev.next=n.next;
            n.next.prev=n.prev;
            n.prev=null;
            n.next=null;
        }

        size--;
    }

    public int get(int key) {
        Node res=map.get(key);
        if(res==null){
            return -1;
        } else {
            remove(res);
            add(res);
            return res.val;
        }
    }
    
    public void put(int key, int value) {
        Node res=map.get(key);
        if(res!=null){
            res.val=value;
            remove(res);
            add(res);
        } else{
            if(size==capacity){
                map.remove(head.key);
                                remove(head);
            }
            Node n = new Node(key, value);
            map.put(key, n);
            add(n);
        }
    }
}
