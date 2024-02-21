package com.dsashorya;
import java.util.*;
public class infixToPostfixPrefix {
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;

        else if (ch == '*' || ch == '/')
            return 2;

        return 0;
    }

    private static String toPostfix(String infix) {
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i) {
            symbol = infix.charAt(i);

            if (Character.isDigit(symbol)) {
                postfix = postfix + symbol;
                System.out.println(postfix);
            } else {
                while (!infixOne.stackIsEmpty() && precedence(symbol) <= precedence(infixOne.peek()))
                    postfix += infixOne.pop();
                infixOne.push(symbol);
            }
        }

        while (!infixOne.stackIsEmpty()) {
            postfix += infixOne.pop();
        }

        return postfix;

    }

    public static String toPrefix(String infix) {
        char symbol;
        String prefix = "";

        for (int i = infix.length() - 1; i >= 0; i--) {
            symbol = infix.charAt(i);
            if (Character.isDigit(symbol)) {
                prefix =  prefix+symbol;
            } else {
                while (!infixOne.stackIsEmpty() && precedence(symbol) < precedence(infixOne.peek())) {
                    prefix += infixOne.pop();
                }
                infixOne.push(symbol);
            }
        }

        while (!infixOne.stackIsEmpty()) {
            prefix += infixOne.pop();
        }
        String s="";
        for (int i =prefix.length()-1; i>=0; i--) {
            s=s+prefix.charAt(i);
        }
        return s;
    }

    public static int evaluatePostfix(String postfix) {


        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isDigit(ch)) {
                infixOne.push((char) (ch - '0'));
            } else {
                int operand2 = infixOne.pop();
                int operand1 = infixOne.pop();

                switch (ch) {
                    case '+':
                        infixOne.push((char) (operand1 + operand2));
                        break;
                    case '-':
                        infixOne.push((char) (operand1 - operand2));
                        break;
                    case '*':
                        infixOne.push((char) (operand1 * operand2));
                        break;
                    case '/':
                        infixOne.push((char) (operand1 / operand2));
                        break;
                }
            }
        }

        return infixOne.pop();
    }


    static stacks infixOne = new stacks((char) 100);
    public static void main(String args[]) {
        String infix;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the infix: ");
        infix = scanner.nextLine();
        String post=toPostfix(infix);
        String pre=toPrefix(infix);
        System.out.println("Postfix:"+post);
        System.out.println("Prefix:"+pre);
        System.out.println(evaluatePostfix(post));
    }
}
class stacks {
    char[] arr;
    int top = -1;
    int size;
    stacks(char s){
        arr=new char[s];
        size=s;
    }
    void push(char x) {
            arr[++top]= x;
    }
    char pop() {
        return arr[top--];
    }
    boolean stackIsEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
    char peek()
    {
        return arr[top];
    }
}




