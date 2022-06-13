package Test;

/**
 * 设计循环队列
 */
class MyCircularQueue {

    public int[] arr;
    public int start;
    public int end;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        arr = new int[k];
        start = 0;
        end = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (end >= arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (start > arr.length - 1) {
            start = 0;
        }
        arr[start++] = 0;
        if (start - end == 1) {
            start = 0;
            end = -1;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return arr[start];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return arr[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */

    public boolean isEmpty() {
        if (start == 0 && end == -1) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */

    public boolean isFull() {
        if ((end - start) == (arr.length - 1) || (start - end == 1 && start != 0)) {
            return true;
        }
        return false;
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
