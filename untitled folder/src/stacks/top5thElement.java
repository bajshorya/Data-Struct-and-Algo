package stacks;


import java.util.Scanner;
import java.util.Stack;

public class top5thElement {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Read the size of the stack
            int n = scanner.nextInt();

            // Create a stack to store the elements
            Stack<Integer> stack = new Stack<>();

            // Read and push elements onto the stack
            for (int i = 0; i < n; i++) {
                int element = scanner.nextInt();
                stack.push(element);
            }

            // Close the scanner
            scanner.close();

            // Check if there are at least 5 elements in the stack
            if (stack.size() < 5) {
                System.out.println("There are not enough elements in the stack");
            } else {
                // Pop the top 4 elements (up to the fifth element from the top)
                for (int i = 0; i < 4; i++) {
                    stack.pop();
                }

                // Print the fifth element from the top
                System.out.println(stack.peek());
            }
    }
}
