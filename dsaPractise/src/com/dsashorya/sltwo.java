package com.dsashorya;
import java.util.Scanner;
class linklist{
    int val;
    linklist next;
    public static linklist insert(linklist head,int val) {
        linklist newnode,scan;
        newnode =new linklist();
        newnode.val=val;
        newnode.next=null;
        if(head==null)
            return newnode;
        if(head.val>val) {
            newnode.next=head;
            return newnode;
        }
        scan=head;
        while(scan.next!=null && scan.next.val<val)
            scan=scan.next;
        newnode.next=scan.next;
        scan.next=newnode;
        return head;
    }
    public void display() {
        linklist scan;
        scan=this;
        while(scan!=null)
        {
            System.out.print(scan.val+" ");
            scan=scan.next;
        }System.out.println();
    }
    public static linklist addToBeginning(linklist head, int val) {
        linklist newnode = new linklist();
        newnode.val = val;
        newnode.next = head;
        return newnode;
    }
    public static linklist addToLast(linklist head, int val) {
    linklist newnode = new linklist();
    newnode.val = val;
    newnode.next = null;

    if (head == null) {
        return newnode;
    }

    linklist currnode = head;
    while (currnode.next != null) {
        currnode = currnode.next;
    }

    currnode.next = newnode;

    return head;
    }
    public static linklist reverseList(linklist head) {
        linklist prev = null;
        linklist current = head;
        linklist next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public static linklist deleteFirst(linklist head){
        if(head==null){
            return null;
        }
        return head.next;
    }
    public static linklist deleteLast(linklist head){
        if(head==null || head.next==null){
            return null;
        }
        linklist last =head;
        while (last.next.next!=null){
            last= last.next;
        }
        last.next=null;
        return head;
    }
    public static linklist addByPosition(linklist head, int val, int position) {
        linklist newnode = new linklist();
        newnode.val = val;
        newnode.next = null;
        if (position == 1) {
            newnode.next=head;
            return newnode;
            }
        linklist scan = head;
        while (scan.next!=null && position>2 ) {
            scan = scan.next;
            position--;
        }
        if (position==2) {
            newnode.next = scan.next;
            scan.next=newnode;
        } else {
            System.out.println("Invalid position!");
        }
        return head;
    }
    public static linklist deleteByPosition(linklist head, int position) {
        if (head == null) {
            System.out.println("Empty List");
            return head;
        }
        if (position == 1) {
            return head.next;
        }
        linklist scan = head;
        int count = 1;
        while (scan.next != null && count < position - 1) {
            scan = scan.next;
            count++;
        }
        if (count == position - 1 && scan.next != null) {
            scan.next = scan.next.next;
        } else {
            System.out.println("Invalid position!");
        }
        return head;
    }
    public static linklist mergell(linklist head1,linklist head2) {
        linklist head = null;
        linklist scan = null;
        if (head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        scan=head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                scan.next = head1;
                head1 = head1.next;
            } else {
                scan.next = head2;
                head2 = head2.next;
            }
            scan = scan.next;
        }
        if (head1 != null) {
            scan.next = head1;
        }else {
            scan.next = head2;
        }
        return head;
    }
}

public class sltwo {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        linklist head=null;
        linklist head2=null;
        int val;
        int val2;
        System.out.println("Enter the number for first ll:");
        val=in.nextInt();
        while(val!=0)
        {
               head=linklist.insert(head,val);

            System.out.println("Enter the number for first ll:");
            val=in.nextInt();
        }
        System.out.println("Enter the number for second ll:");
        val=in.nextInt();
        while(val!=0)
        {
            head2=linklist.insert(head2,val);

            System.out.println("Enter the number:");
            val=in.nextInt();
        }
        head.display();
        head2.display();
        linklist ans=linklist.mergell(head,head2);
        ans.display();
        System.out.println("Enter the number to add at the beginning:");
        val=in.nextInt();
        head=linklist.addToBeginning(head,val);
        System.out.println("Enter the number to add at last:");
        val=in.nextInt();
        head=linklist.addToLast(head,val);
        head.display();
        head=linklist.reverseList(head);
        System.out.println("Reversed ");
        head.display();
        head=linklist.deleteFirst(head);
        System.out.println("after deleting first:-");
        head.display();
        head=linklist.deleteLast(head);
        System.out.println("after deleting last:-");
        head.display();
        System.out.println("Enter the number to add:");
        val = in.nextInt();
        System.out.println("Enter the position to add at:");
        int position = in.nextInt();
        head = linklist.addByPosition(head, val, position);
        head.display();
        System.out.println("Enter the position to delete at:");
        int deletepos = in.nextInt();
        head = linklist.deleteByPosition(head, deletepos);
        head.display();

    }
}
