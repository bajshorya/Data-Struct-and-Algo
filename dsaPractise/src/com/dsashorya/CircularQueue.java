package com.dsashorya;
class CQueue{
    int val;
    CQueue next;
    CQueue()
    {
        next=null;
    }
    public void enQueue(int val){
        CQueue newnode = new CQueue();
        newnode.val = val;
        newnode.next = null;
        if (next == null) {
            next= newnode;
            next.next=next;

            return;
        }
        newnode.next=next.next;
        next.next=newnode;
        next=newnode;
    }
    public int deQueue() {
        if(next==null){
            return -1;
        }
        int val=next.next.val;
        if (next == next.next){
            next=null;
        }else {
            next.next=next.next.next;
        }
        return val;
    }

}
public class CircularQueue {
    public static void main(String[] args) {
        CQueue circularQueue = new CQueue();

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);

        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
    }
}