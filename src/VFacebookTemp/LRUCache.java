package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.

 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    public class Node{
        Node pre;
        Node next;
        int value;
        int key;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int cap;
    int size;
    Node head;
    Node tail;
    Map<Integer,Node> map = new HashMap();

    public LRUCache(int capacity) {
        size = 0;
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void movefront(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            movefront(temp);
            return temp.value;
        }
        else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            movefront(temp);
            temp.value = value;
        }
        else{
            Node temp = new Node(key, value);
            map.put(key,temp);
            if(size<cap){
                size++;
            }else{
                Node old = tail.pre;
                remove(old);
                map.remove(old.key);
            }
            movefront(temp);
        }
    }
}
