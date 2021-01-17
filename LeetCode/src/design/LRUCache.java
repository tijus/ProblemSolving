package design;


import java.util.HashMap;
import java.util.Map;

/*
Node(key, val, pre = null, next = null);

constructor () {
int capacity;
HashMap<key, Node> map;
Node head, Node tail;
}

put(key, value) {
Node currNode = new Node(key, value);

 if (head == null) {
   map.put(key, currNode);
   head = currNode;
   tail = currNode;
 } else {
    if (key doesnot exists) {
        currNode.pre = tail
        tail.next = currNode
        tail = tail.next
        map.put(key, currNode);
        if (map.size() > capacity) {
            head = head.next;
        }
    } else {
        currNode = map.get(key);
        currNode.pre.next = currNode.next
        currNode.next = currNode.next.next
        currNode.value = val;
        currNode.pre = tail
        tail.next = currNode
        tail = tail.next
        map.put(key, currNode);
        if (map.size() > capacity) {
        head = head.next;
    }
 }
}


get =

 */
public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size = 0;

    Map<Integer, Node> map;

    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node currNode = map.get(key);

        if (currNode == null) {
            return -1;
        }

        removeOldNode(currNode);
        addNewNode(currNode);

        return currNode.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node currNode = new Node(key, value);
            addNewNode(currNode);
            map.put(key, currNode);

            size++;

            if (size > capacity) {
                Node res = removeFromTail();
                map.remove(res.key);
                size--;
            }
        } else {
            Node currNode = map.get(key);
            removeOldNode(currNode);
            currNode.value = value;
            addNewNode(currNode);
            map.put(key, currNode);
        }
    }


    private Node removeFromTail() {
        Node tailPrev = tail.prev;
        removeOldNode(tailPrev);
        return tailPrev;
    }

    private void removeOldNode(Node currNode) {

        Node prev = currNode.prev;
        Node next = currNode.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNewNode(Node currNode) {

        currNode.next = head.next;
        currNode.prev = head;

        head.next.prev = currNode;
        head.next = currNode;
    }
}
