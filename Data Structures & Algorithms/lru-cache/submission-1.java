class LRUCache {

    class Node {
        int val;
        int k;
        Node prev;
        Node next;

        public Node(int k,int val) {
            this.k = k;
            this.val = val;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        int capacity;

        public DoublyLinkedList(int capacity) {
            this.size = 0;
            this.capacity = capacity;
        }
    }

    private DoublyLinkedList list;
    private Map<Integer,Node> mp;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList(capacity);
        this.mp = new HashMap<>();    
    }

    public Node removeNodeAndAddLast(Node node) {
        if(node == list.head) {
            node.next.prev = null;
            list.head=list.head.next;
        }
        else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        node.next = null;
        node.prev = list.tail;
        list.tail.next = node;
        list.tail = list.tail.next;
        return node;    
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) {
            return -1;
        }
        Node node = mp.get(key);
        if(list.head == list.tail || node == list.tail) {
            return node.val;
        }
        removeNodeAndAddLast(node);
        return node.val;    
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            Node temp = mp.get(key);
            temp.val = value;
            if(list.head != list.tail && temp != list.tail) {
                removeNodeAndAddLast(temp);
            }
            return;
        }
        Node node = new Node(key,value);
        if(list.size == list.capacity) {
            mp.remove(list.head.k);
            if(list.head == list.tail) {
                list.head=null;
                list.tail=null;
            }
            else {
                list.head.next.prev = null;
                list.head = list.head.next;
            }
            list.size--;
        }
        if(list.head == null) {
            list.head = node;
            list.tail = node;
        }
        else {
            list.tail.next = node;
            node.prev = list.tail;
            list.tail = list.tail.next;
        }
        mp.put(key,node);
        list.size++;   
    }
}
