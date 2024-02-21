package com.dsashorya;
import java.util.Scanner;
class poly {
    int coefficient;
    int exponent;
    poly next;
    public static poly insert(poly head, int coefficient, int exponent){
        poly newnode,scan,prev;
        newnode=new poly();
        newnode.coefficient=coefficient;
        newnode.exponent=exponent;
        if(head==null){
            return newnode;
        }if(head.exponent==exponent){
            head.coefficient+=coefficient;
            return head;
        }
        if(head.exponent<exponent) {
            newnode.next=head;
            return newnode;
        }
        scan=head;
        while(scan.next!=null && scan.next.exponent>exponent) {
            scan = scan.next;
        }
        if(scan.next.exponent==exponent){
            scan.next.coefficient+=coefficient;
            return head;
        }
        newnode.next=scan.next;
        scan.next=newnode;
        return head;
    }
    public static int evaluate(poly head, int valForCoef) {
        int result = 0;
        poly current = head;
        while (current != null) {
            int coefficient = current.coefficient;
            int exponent = current.exponent;
            int termValue = (int) (coefficient * Math.pow(valForCoef, exponent));
            result += termValue;
            current = current.next;
        }
        return result;
    }
    public static poly add(poly head1,poly head2){
        poly head = null;
        poly scan = null;
        if (head1.exponent > head2.exponent) {
            head = head1;
            head1 = head1.next;
        } else if(head1.exponent < head2.exponent){
            head = head2;
            head2 = head2.next;
        }
        else {
            head=head1;
            head.coefficient+=head2.coefficient;
            head1=head1.next;
            head2=head2.next;
        }
        scan=head;
        while (head1 != null && head2 != null) {
            if (head1.exponent > head2.exponent) {
                scan.next = head1;
                head1 = head1.next;
            } else if (head1.exponent < head2.exponent){
                scan.next = head2;
                head2 = head2.next;
            }else{
                scan.next=head1;
                scan.next.coefficient+=head2.coefficient;
                head1=head1.next;
                head2=head2.next;
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
    public void display() {
        poly scan;
        scan = this;
        while (scan != null) {
            if (scan.coefficient != 0) {
                if (scan.coefficient > 0) {
                    System.out.print("+");
                }
                if (scan.exponent == 0) {
                    System.out.print(scan.coefficient);
                } else if (scan.exponent == 1) {
                    System.out.print(scan.coefficient + "x");
                } else {
                    System.out.print(scan.coefficient + "x^" + scan.exponent);
                }
            }
            scan = scan.next;
        }
        System.out.println();
    }


}
public class Polynomial {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        poly head=null;
        int coefficient;
        int exponent;
        System.out.println("Enter the coef.:");
        coefficient=in.nextInt();
        while(coefficient!=0){
            System.out.println("enter expo.");
            exponent=in.nextInt();
            head= poly.insert(head,coefficient,exponent);
            System.out.println("Enter the coef.:");
            coefficient=in.nextInt();
        }
        poly head2=null;
        System.out.println("Enter the coef.:");
        coefficient=in.nextInt();
        while(coefficient!=0){
            System.out.println("enter expo.");
            exponent=in.nextInt();
            head2= poly.insert(head2,coefficient,exponent);
            System.out.println("Enter the coef.:");
            coefficient=in.nextInt();
        }
        head.display();
        head2.display();

        poly ans=poly.add(head,head2);
        ans.display();

    }
}