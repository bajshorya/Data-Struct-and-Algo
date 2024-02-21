package QueuePac;
import java.util.Stack;

class QueueUsingOneStack {
    Stack<Integer> stack;

    public QueueUsingOneStack() {
        stack = new Stack<>();
    }

    public void enqueue(int value) {
        stack.push(value);
    }

    public int dequeue() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Assuming -1 indicates an error or empty queue
        }

        int value = stack.pop();

        if (stack.isEmpty()) {
            return value;
        }

        int result = dequeue(); // Recursively pop items until reaching the last element
        stack.push(value); // Push all elements back except the last one popped

        return result;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingOneStack queue = new QueueUsingOneStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 1
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 2

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 3
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 4
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 5

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
    }
}
