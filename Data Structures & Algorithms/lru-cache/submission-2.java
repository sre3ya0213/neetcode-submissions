class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int val) {
            this.key = key;
            this.value = val;
        }
    }

    Map<Integer,Node> nodes;
    int capacity;
    Node left;
    Node right;
    int size;
    public LRUCache(int capacity) {
        this.nodes = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }

    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insert(Node node) {
        right.prev.next = node;
        node.next = right;
        node.prev = right.prev;
        right.prev = node;
    }
    
    public int get(int key) {
        if(!nodes.containsKey(key)){
            return -1;
        }
        Node node = nodes.get(key);
        if(node != right.prev) {
            remove(node);
            insert(node);
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;
        if(nodes.containsKey(key)) {
            node = nodes.get(key);
            node.value = value;
            if(node != right.prev) {
                remove(node);
                insert(node);
            }
            return;
        }
        if(size == capacity) {
            nodes.remove(left.next.key);
            remove(left.next);
            size--;
        }
        node = new Node(key,value);
        insert(node);
        size++;
        nodes.put(key,node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */