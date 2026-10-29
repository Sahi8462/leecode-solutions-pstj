class MyHashMap {

    private static final int SIZE = 1000;

    private Node[] buckets;

    // Node class
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Constructor
    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = key % SIZE;

        Node current = buckets[index];

        // Check if key already exists
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Get value for the given key
    public int get(int key) {
        int index = key % SIZE;

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = key % SIZE;

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }
}