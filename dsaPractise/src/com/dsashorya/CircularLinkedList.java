package com.dsashorya;
import java.util.Scanner;

class CLL {
    int val;
    CLL next;
    public static CLL insert(CLL head, int val) {
        CLL newnode = new CLL();
        newnode.val = val;
        if (head == null) {
            newnode.next = newnode;
            return newnode;
        }
        CLL current = head;
        if(head.val>val)
        {
            newnode.next=head;
            while (current.next!=head)
                current=current.next;
            current.next=newnode;
            return newnode;
        }

        while (current.next != head && current.next.val<val) {
            current = current.next;
        }
        newnode.next=current.next;
        current.next = newnode;
        return head;
    }
    public static CLL addLast(CLL head,int val){
        CLL newnode = new CLL();
        newnode.val = val;
        if (head == null) {
            newnode.next = newnode;
            return newnode;
        }
        CLL currnode = head;
        while (currnode.next != head) {
            currnode = currnode.next;
        }
        newnode.next=head;
        currnode.next = newnode;
        return head;
    }
    public static CLL addToBeginning(CLL head, int val) {
        CLL newnode = new CLL();
        newnode.val = val;
        if (head == null) {
            newnode.next = newnode;
            return newnode;
            }
        CLL last =head;
        while (last.next != head) {
            last = last.next;
            }
        newnode.next = head;
        last.next=newnode;
        return newnode;
    }
    public static CLL addByPosition(CLL head, int val, int position) {
        CLL newnode = new CLL();
        newnode.val = val;
        newnode.next = null;
        if (position == 1) {
            CLL last =head;
            while (last.next != head) {
                last = last.next;
            }
            newnode.next = head;
            last.next=newnode;
            return newnode;
        }
        CLL scan = head;
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
    public static CLL deleteAtFirstPosition(CLL head) {
        if (head == null || head.next == head) {
            return null;
        }
//        CLL firstNode = head;
        CLL lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
//        head = firstNode.next;
        lastNode.next = head.next;
//        firstNode.next = null;
        head=head.next;
        return head;
    }
    public static CLL deleteAtLastPosition(CLL head) {
        if (head == null || head.next == head) {
            return null;
        }
        CLL lastNode = head;
        while (lastNode.next.next != head) {
            lastNode = lastNode.next;
        }
        lastNode.next = head;
        return head;
    }
    public static CLL deleteByPosition(CLL head, int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        if (position == 1) {
            if (head.next == head) {
                return null;
            }
            CLL lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            head = head.next;
            lastNode.next = head;
            return head;
        }
        int count = 1;
        CLL current = head;
        CLL prev = null;
        do {
            prev = current;
            current = current.next;
            count++;
        } while (current != head && count < position);
        if (count == position) {
            prev.next = current.next;
            current.next = null;
        } else {
            System.out.println("Invalid position!");
        }
        return head;
    }
    void display() {
         CLL scan;
         scan=this;
         while(scan.next!=this)
         {
             System.out.print(scan.val+" ");
             scan=scan.next;
         }
         System.out.println(scan.val);

     }

}
public class CircularLinkedList{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        CLL head=null;
        int val;
        val=in.nextInt();
        while(val!=0)
        {
            head=CLL.insert(head,val);
            System.out.println("enter number");
            val= in.nextInt();
        }
        head.display();
        System.out.println("Enter the number to add at the beginning:");
        val=in.nextInt();
        head=CLL.addToBeginning(head,val);
        System.out.println("Enter the number to add at last:");
        val=in.nextInt();
        head=CLL.addLast(head,val);
        head.display();

    }
}
