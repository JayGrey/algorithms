package org.example.ex._1._3._47;

import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._29.CircularLinkedListQueue;
import org.example.ex._1._3._32.Steque;
import org.example.ex._1._3._7.Stack;

public class CollectionsUtil {

    public static <T> Queue<T> concatenate(Queue<T> queue1, Queue<T> queue2) {
        final CircularLinkedListQueue<T> result = new CircularLinkedListQueue<>();

        if (queue1 != null && !queue1.isEmpty()) {
            final int size = queue1.size();
            for (int i = 0; i < size; i++) {
                result.enqueue(queue1.dequeue());
            }
        }

        if (queue2 != null && !queue2.isEmpty()) {
            final int size = queue2.size();
            for (int i = 0; i < size; i++) {
                result.enqueue(queue2.dequeue());
            }
        }

        return result;
    }

    public static <T> Stack<T> concatenate(Stack<T> stack1, Stack<T> stack2) {
        final Stack<T> result = new Stack<>();

        if (stack2 != null && !stack2.isEmpty()) {
            appendToStack(stack2, result);
        }

        if (stack1 != null && !stack1.isEmpty()) {
            appendToStack(stack1, result);
        }

        return result;
    }

    public static <T> Steque<T> concatenate(Steque<T> steque1, Steque<T> steque2) {
        final Steque<T> result = new Steque<>();

        if (steque1 != null) {
            while (!steque1.isEmpty()) {
                result.enqueue(steque1.pop());
            }
        }

        if (steque2 != null) {
            while (!steque2.isEmpty()) {
                result.enqueue(steque2.pop());
            }
        }

        return result;
    }

    private static <T> void appendToStack(Stack<T> source, Stack<T> dest) {
        final Stack<T> tempStack = new Stack<>();
        while (!source.isEmpty()) {
            tempStack.push(source.pop());
        }
        while (!tempStack.isEmpty()) {
            dest.push(tempStack.pop());
        }
    }
}
