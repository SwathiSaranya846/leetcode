import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DoublyLinkedList> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node removed = list.removeLast();

            map.remove(removed.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        map.put(key, newNode);

        freqMap
            .computeIfAbsent(1, x -> new DoublyLinkedList())
            .addFirst(newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // If this was the last node with minimum frequency
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap
            .computeIfAbsent(node.freq, x -> new DoublyLinkedList())
            .addFirst(node);
    }
}