public class Node{
    int key,val;
    Node prev,next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {
    private int cap;
    private HashMap<Integer,Node>cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if it is present , delete it from cache.
        if(cache.containsKey(key))delete(cache.get(key));
        Node newNode = new Node(key, value);
        cache.put(key,newNode);
        addToHead(newNode);
        if(cache.size() > cap){
            Node lru = this.tail.prev;
            delete(lru);
            cache.remove(lru.key);
        }

    }

    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void addToHead(Node node){
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
}
