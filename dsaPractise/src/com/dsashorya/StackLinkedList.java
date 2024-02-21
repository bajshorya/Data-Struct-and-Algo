package com.dsashorya;
import java.util.*;
class Node {
    int val;
    Node next;
    public void push(int val) {
        Node newnode = new Node();
        newnode.val = val;
        newnode.next = next;
        next = newnode;
    }
    public int pop() {
        if(next==null){
           return -1;
        }
        int val=next.val;
        next=next.next;
        return val;
    }
}

public class StackLinkedList {
    public static void main(String[] args) {
        Node s = new Node();
        int val,c;
        Scanner in=new Scanner (System.in);
        while(true)
        {
            System.out.println("Enter choice 1. push 2. pop 3.exit");
            c= in.nextInt();
            if(c==1)
            {
                System.out.println("Enter the number to push in the stack:-");
                val=in.nextInt();
                s.push(val);
            } else if (c==2) {
                val= s.pop();
                if(val==-1){
                    System.out.println("Stack is empty");
                }else {
                    System.out.println(val);
                }
            }else {
                break;
            }
        }
    }
}
