package org.example.ex._1._3._15;

import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._14.ResizingArrayQueueOfStrings;

public class Runner {
    public static void main(String[] args) {
        Queue<String> queue = new ResizingArrayQueueOfStrings();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        String kth = getKthElementFromEndOfQueue(queue, 3);

        System.out.format("%s, %s, %s", "1", kth, "1".equals(kth));
    }

    private static String getKthElementFromEndOfQueue(Queue<String> queue, int k) {
        if (queue == null || k >= queue.size()) {
            throw new IllegalArgumentException();
        }

        String value = null;
        for (int i = queue.size() - k - 1; i >=0 ; i--) {
            value = queue.dequeue();
        }

        return value;
    }
}
