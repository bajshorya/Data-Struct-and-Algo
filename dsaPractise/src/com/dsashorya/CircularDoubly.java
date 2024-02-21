package com.dsashorya;
import java.util.*;
class CirDoubly {
    int val;
    CirDoubly next;
    CirDoubly prev;

    public static CirDoubly insert(CirDoubly head, int val) {
        CirDoubly newnode = new CirDoubly();
        newnode.val = val;
        newnode.prev = null;
        newnode.next = null;
        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            return newnode;
        }
        CirDoubly current = head;
        if (head.val > val) {
            newnode.next = head;
            newnode.prev = head.prev;
            head.prev.next = newnode;
            head.prev = newnode;
            return newnode;
        }
        while (current.next != head && current.next.val < val) {
            current = current.next;
        }
        newnode.next = current.next;
        newnode.prev = current;
        current.next.prev = newnode;
        current.next = newnode;

        return head;
    }
    public static CirDoubly addFirst(CirDoubly head, int val) {
        CirDoubly newnode=new CirDoubly();
        newnode.val=val;
        newnode.prev=null;
        newnode.next=null;
        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            return newnode;
        }
        newnode.next = head;
        newnode.prev = head.prev;
        head.prev.next = newnode;
        head.prev = newnode;
        return newnode;
    }
    public static CirDoubly addByPosition(CirDoubly head, int val, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return head;
        }
        CirDoubly newnode = new CirDoubly();
        newnode.val = val;
        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            return newnode;
        }
        if (position == 0) {
            newnode.next = head;
            newnode.prev = head.prev;
            head.prev.next = newnode;
            head.prev = newnode;
            return newnode;
        }
        int currentPosition = 0;
        CirDoubly current = head;

        while (current.next != head && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }
        newnode.next = current.next;
        newnode.prev = current;
        current.next.prev = newnode;
        current.next = newnode;

        return head;
    }

    public static CirDoubly addToLast(CirDoubly head, int val) {
        CirDoubly newnode = new CirDoubly();
        newnode.val = val;

        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            return newnode;
        }
        CirDoubly scan = head;
        while (scan.next != head) {
            scan = scan.next;
        }
        newnode.prev = scan;
        newnode.next=head;
        scan.next.prev = newnode;
        scan.next=newnode;
        return head;
    }
    public static CirDoubly deleteFirst(CirDoubly head){
        if (head == null || head.next==head) {
            return null;
        }
        CirDoubly lastNode=head.prev;
        lastNode.next=head.next;
        head = head.next;
        head.prev=lastNode;
        return head;
    }
    public static CirDoubly deleteLast(CirDoubly head){
        if (head == null || head.next == head) {
            return null;
        }
        CirDoubly lastNode = head.prev;
        lastNode.prev.next=head;
        head.prev=lastNode.prev;
        return head;
    }
    public static CirDoubly deleteByPosition(CirDoubly head,int position){
        if (head == null || head.next == head) {
            return null;
        }
        if (position < 0) {
            System.out.println("Invalid position");
            return head;
        }
        if (position == 0) {
            CirDoubly lastNode=head.prev;
            lastNode.next=head.next;
            head = head.next;
            head.prev=lastNode;
            return head;
        }
        int currentPosition = 0;
        CirDoubly current = head;
        while (current.next != head && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }
        if (currentPosition != position) {
            System.out.println("Position out of range");
            return head;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return head;
    }
    public static CirDoubly deleteByValue(CirDoubly head, int val) {
        if (head == null || head.next == head) {
            return null;
        }
        CirDoubly current = head;
        if(current.val ==val) {
            current = current.next;
            current.prev = current.prev.prev;
            return current;
        }
        while (current.next!=head && current.next.val!=val ){
            current=current.next;
        }
        if(current.next==head){
            System.out.println("Value not found");
            return head;
        }
        current.next.prev=current;
        current.next=current.next.next;


        return head;
    }
    public void  printStraight(CirDoubly head) {
        CirDoubly current = head;
        while (current.next != head) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println(current.val);
    }
    public void printReverse(CirDoubly head){
            if (head == null) {
                System.out.println("Empty list");
                return;
            }
            CirDoubly current = head.prev;
            while (current != head) {
                System.out.print(current.val + " ");
                current = current.prev;
            }
            System.out.println(head.val);
    }


}


public class CircularDoubly {
    public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            CirDoubly head=null;
            int val;
            System.out.println("Enter the number ");
            val=in.nextInt();
            while(val!=0)
            {
                head=CirDoubly.insert(head,val);
                System.out.println("Enter the number ");
                val=in.nextInt();
            }
            head.printStraight(head);
            head.printReverse(head);
            int val1=4;
            int val2=78;

            head=CirDoubly.addFirst(head,val1);
            head=CirDoubly.addToLast(head,val2);
            head.printStraight(head);

            head=CirDoubly.deleteFirst(head);
            head.printStraight(head);

            head=CirDoubly.deleteLast(head);
            head.printStraight(head);


    }
}
