class MyCircularDeque {

    int[] deque;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert at front
    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        deque[front] = value;
        size++;

        return true;
    }

    // Insert at rear
    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        deque[rear] = value;
        size++;

        return true;
    }

    // Delete from front
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;

        return true;
    }

    // Delete from rear
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;

        return true;
    }

    // Get front element
    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    // Get rear element
    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return deque[rear];
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check full
    public boolean isFull() {
        return size == capacity;
    }
}