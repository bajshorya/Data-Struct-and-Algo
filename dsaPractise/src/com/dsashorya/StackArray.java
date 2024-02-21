package com.dsashorya;

public class StackArray {
    public static void main(String[] args) {
        //read a string infix 2+3*4-5
        //loop in method
        stack s = new stack(10);
        s.push(6);
        s.push(3);
        s.push(7);
    }
}
class stack {
    int arr[] ;
    //char[] arr;
    int top = -1;
    int size;
    stack(int s){
        arr=new int[s];
        size=s;
    }
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }
}