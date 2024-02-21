package com.dsashorya;

import java.util.Scanner;

class QNode {
    int val;
    QNode next;
    QNode()
    {
        next=null;
    }
    public void enQueue(int val){
        QNode newnode = new QNode();
        newnode.val = val;
        newnode.next = null;
        if (next == null) {
            next= newnode;
            return;
        }
        QNode currnode = next;
        while (currnode.next != null) {
            currnode = currnode.next;
        }
        currnode.next = newnode;
    }
    public int deQueue() {
        if(next==null){
            return -1;
        }
        int val=next.val;
        next=next.next;
        return val;
    }

}
public class queueLinkedList {
    public static void main(String[] args) {

            QNode s = new QNode();
            int val,c;
            Scanner in=new Scanner (System.in);
            while(true)
            {
                System.out.println("Enter choice 1. enQueue 2. deQueue 3.exit");
                c= in.nextInt();
                if(c==1)
                {
                    System.out.println("Enter the number to enQueue :-");
                    val=in.nextInt();
                    s.enQueue(val);
                } else if (c==2) {
                    val= s.deQueue();
                    if(val==-1){
                        System.out.println("Queue is empty");
                    }else {
                        System.out.println(val);
                    }
                }else {
                    break;
                }
            }

    }
}
