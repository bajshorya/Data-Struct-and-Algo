package com.dsashorya;
import java.util.*;
class Dll{
    private static int position;
    int val ;
    Dll next;
    Dll prev;
    public static Dll insert(Dll head, int val) {
        Dll newNode,current;
        newNode =new Dll();
        newNode.val=val;
        newNode.prev=null;
        newNode.next=null;
        if(head==null)
            return newNode;
        if(head.val>val)
        {
            newNode.next=head;
            head.prev=newNode;
            return newNode;
        }
        current=head;
        while(current.next!=null && current.next.val<val){
            current=current.next;
        }
        newNode.next=current.next;
        newNode.prev=current;
        if(current.next!=null)
            current.next.prev=newNode;
        current.next=newNode;
        return head;
    }
    public static Dll addFirst(Dll head,int val){
        Dll newNode = new Dll();
        newNode.val=val;
        newNode.prev=null;
        newNode.next=null;
        if (head!=null){
            head.prev=newNode;
            newNode.next=head;
        }
        return newNode;
    }
    public static Dll addToLast(Dll head, int val) {
        Dll newNode = new Dll();
        newNode.val = val;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            return newNode;
        }
        Dll scan = head;
        while (scan.next != null) {
            scan = scan.next;
        }
        scan.next = newNode;
        newNode.prev = scan;
        return head;
    }
    public static Dll addByPosition(Dll head,int val,int position){
        Dll.position = position;
        Dll newnode = new Dll();
        newnode.val = val;
        newnode.next = null;
        if (position == 1) {
            newnode.next=head;
            head.prev=newnode;
            newnode.prev=null;
            return newnode;
        }
        Dll scan = head;
        while (scan.next!=null && position>2 ) {
            scan = scan.next;
            position--;
        }
        if (position==2) {
            newnode.next = scan.next;
            newnode.prev=scan;
            if (scan.next!=null){
                scan.next.prev=newnode;
            }
            scan.next=newnode;
        } else {
            System.out.println("Invalid position!");
        }
        return head;
    }
    public void  printStraight(Dll head) {
        Dll current = head;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println();
    }
    public void  printReversed(Dll head) {
        Dll current = head;
        if (current == null) {
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.prev;
        }
        System.out.println();
    }
    public static Dll deleteLast(Dll head) {
        if (head == null || head.next == null) {
            return null;
        }
        Dll current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        return head;
    }
    public static Dll deleteFirst(Dll head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }
    public static Dll deleteByPosition(Dll head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Dll current = head;
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        return head;
    }
    public static Dll deleteByValue(Dll head, int val) {
        if (head == null) {
            return null;
        }
       if (head.val == val) {
             head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Dll current = head;
        while (current != null && current.val != val) {
            current = current.next;
        }

        if (current == null) {
            return head;
        }
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        return head;
    }
}
public class doublylinkedlist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dll head = null;
        int val;
        System.out.println("Enter the number:");
        val = in.nextInt();
        while (val != 0) {
            head = Dll.insert(head, val);

            System.out.println("Enter the number:");
            val = in.nextInt();
        }
        head.printStraight(head);
        head.printReversed(head);

        System.out.println("Enter the number to add at the beginning:");
        val = in.nextInt();
        head = Dll.addFirst(head, val);

        System.out.println("Enter the number to add to the last:");
        val = in.nextInt();
        head = Dll.addToLast(head, val);

        System.out.println("Enter the position you wanna enter");
        int position= in.nextInt();
        System.out.println("Enter the number you wanna enter at that particular position ");
        int number= in.nextInt();
        head=Dll.addByPosition(head,number,position);
        head.printStraight(head);

        System.out.println("list :-");
        head.printStraight(head);

        System.out.println("list in reverse:-");
        head.printReversed(head);

        head=Dll.deleteFirst(head);
        head.printStraight(head);
        head.printReversed(head);

        head=Dll.deleteLast(head);
        head.printStraight(head);
        head.printReversed(head);

        System.out.println("enter the position to delete !!");
        int pos=in.nextInt();
        head=Dll.deleteByPosition(head,pos);
        head.printStraight(head);
        head.printReversed(head);

        System.out.println("enter the value you wanna delete !");
        int value= in.nextInt();
        head=Dll.deleteByValue(head,value);
        head.printStraight(head);
        head.printReversed(head);




    }
}

