package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L146_LRUCache {
    class LRUCache2 {
        private final int MAX_SIZE;
        Map<Integer, Integer> map;
        public LRUCache2(int capacity) {
            MAX_SIZE = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return this.size() > MAX_SIZE;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key,-1);
        }
        public void put(int key, int value) {
            map.put(key, value);
        }
    }
    static class LRUCache {
        Map<Integer, Node> map;
        Node first = null;
        Node last = null;
        int  capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node n = map.get(key);
            if (n == null) return -1;
            remove(n);
            addToHead(n);
            return n.value;
        }

        public void addToHead(Node n){
            if (first == null) {
                first = n;
                last = n;
            } else {
                n.prev = null;
                n.next = first;
                first.prev = n;
                first = n;
            }
        }

        public void remove(Node n){
            if (n.prev != null) n.prev.next=n.next;
            if (n.next != null) n.next.prev = n.prev;

            if (n == last) last = n.prev;
            if (n == first) first = n.next;
        }

        public void put(int key, int value) {
            Node n;
            if ((n=map.get(key)) != null){
                n.value = value;
                remove(n);
                addToHead(n);
            } else {
                if (map.size() >= capacity){
                    map.remove(last.key);
                    remove(last);
                }
                n = new Node(key,value);
                map.put(key,n);
                addToHead(n);
            }
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.get(1);
        cache.get(6);
        cache.get(8);
        cache.put(12,1);
        cache.get(2);
        cache.put(15,11);
        cache.put(5,2);
        cache.put(1,2);

    }
}
