package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    private final int DEFAULT_CAPACITY = 5;
    private int maxCapacity;
    private int currentCapacity = 0;

    private String[] queue;

    private int head = 0;
    private int tail = 0;

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        maxCapacity = DEFAULT_CAPACITY;
        queue = new String[maxCapacity];
    }


    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        maxCapacity = capacity;
        queue = new String[maxCapacity];
    }

    @Override
    public int size() {
        return currentCapacity;
    }

    @Override
    public boolean isEmpty() {
        return currentCapacity == 0;
    }

    @Override
    public boolean isFull() {
        return currentCapacity == maxCapacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if(isFull() || obj == null) {
            return false;
        } else {
            currentCapacity++;

            queue[tail] = obj;
            tail = (tail + 1)%maxCapacity;
            return true;
        }
    }

    @Override
    public String dequeue() {
        if(isEmpty()){
            return null;
        } else {
            currentCapacity--;
            //TODO queue
            String ret = queue[head];
            head = (head + 1)%maxCapacity;
            return ret;
        }
    }

    @Override
    public void printAllElements() {
        int index = head;
        while (index != tail){
            System.out.println(queue[index]);
            index = (index + 1)%maxCapacity;
        }
    }
}
