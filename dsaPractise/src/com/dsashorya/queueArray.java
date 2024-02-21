package com.dsashorya;
class Queue {
    int front,rear,capacity;
    int[] queue;
    Queue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }
    void queueEnqueue(int item)  {
        if (capacity == rear) {
            System.out.println("queue is full");
            return;
        }
        else {
            queue[rear] = item;
            rear++;
        }
    }
    int queueDequeue(){
        if(front==rear){
            System.out.println("empty queue");
            return -1;
        }
        return queue[front++];
        }

    void queueDisplay() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty\n");
            return;
        }
        for (i = front; i < rear; i++) {
            System.out.println( queue[i] +",");
        }
    }
}
public class queueArray {
    public static void main(String[] args)
    {
        Queue queue = new Queue(3);

        queue.queueEnqueue(1);
        queue.queueEnqueue(2);
        queue.queueEnqueue(3);
        queue.queueEnqueue(4);

        int val=queue.queueDequeue();
        System.out.println(val);
        queue.queueDisplay();
        queue.queueEnqueue(4);
    }
}
