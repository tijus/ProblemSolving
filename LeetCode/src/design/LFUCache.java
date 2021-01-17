package design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private static final int INITIAL_FREQ = 1;

    int minFreq = 0;
    int capacity;
    Map<Integer, Node> map, fMap;

    private class Node {
        int key;
        int value;
        int freq = 1;
        Node next = null;
        Node prev = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.fMap = new HashMap<>();
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {

        if (!map.containsKey(key)) {
            Node n;
            // this means this is fresh key
            if (!fMap.containsKey(INITIAL_FREQ)) {
                n = new Node(key, value);
                map.put(key, n);
            } else {
                n = fMap.get(INITIAL_FREQ);
                Node currentNode = new Node(key,value);
                n.next = currentNode;
                currentNode.prev = n;
                map.put(key, currentNode);
            }
            fMap.put(INITIAL_FREQ, n);
        } else {
            // This means the key exists
            // get the node and update frequency of the node
            // add to the map with updated frequency
            // add to the fmap with updated frequency
            // remove node from the previous frequency
            Node n = map.get(key);
            Node fNode = fMap.get(n.freq);
            while (fNode != null) {
                if (fNode.key == key) {

                }
                fNode = fNode.next;
            }

        }
    }

    private void updateMinFreq(int freq){
        if (minFreq == 0) {
            minFreq = 1;
        } else {
            minFreq = Math.min(minFreq, freq);
        }
    }

    private void updateFreqMap(Node n) {

    }

}
