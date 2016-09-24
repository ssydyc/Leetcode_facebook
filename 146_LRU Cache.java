class LinkedListNode {
    LinkedListNode prev;
    LinkedListNode next;
    int value;
    int key;
    
    public LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

public class LRUCache {
    LinkedListNode head;
    LinkedListNode tail;
    HashMap<Integer, LinkedListNode> valueMap;
    int capacity;
    
    public LRUCache(int capacity) {
        valueMap = new HashMap<Integer, LinkedListNode>();
        head = new LinkedListNode(0, 0);
        tail = new LinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        } 
        
        LinkedListNode cur = valueMap.get(key);
        
        // move this node to front
        cur.prev.next = cur.next;
        cur.next.prev= cur.prev;
        LinkedListNode temp = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = temp;
        temp.prev= cur;
        
        return cur.value;
    }
    
    public void set(int key, int value) {
        LinkedListNode cur = null;
        if (valueMap.containsKey(key)) {
            cur = valueMap.get(key);
            cur.value = value;
            cur.prev.next = cur.next;
            cur.next.prev= cur.prev;
        } else {
            cur = new LinkedListNode(key, value);
            valueMap.put(key, cur);
        }
        
        // move the node to the front
        LinkedListNode temp = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = temp;
        temp.prev= cur;
        
        if (valueMap.size() > capacity) {
            LinkedListNode removeNode = tail.prev;
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
            valueMap.remove(removeNode.key);
        }
    }
}
