package org.example.ex._1._3._47;

import org.example.ex._1._3._32.Steque;
import org.example.ex._1._3._35.ResizingArrayQueue;
import org.example.ex._1._3._7.Stack;
import org.example.ex._1._3._9.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsUtilTest {

    @Test
    public void concatenateQueueTest() {
        final Queue<Integer> queue1 = new Queue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        final ResizingArrayQueue<Integer> queue2 = new ResizingArrayQueue<>();
        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.enqueue(6);

        final org.example.ex._1._3._14.Queue<Integer> result = CollectionsUtil.concatenate(queue1, queue2);
        assertEquals(6, result.size());

        int i = 1;
        while (!result.isEmpty()) {
            assertEquals(i++, result.dequeue());
        }
    }

    @Test
    public void concatenateStackTest() {
        final Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);

        final Stack<Integer> stack2 = new Stack<>();
        stack2.push(6);
        stack2.push(5);
        stack2.push(4);

        final Stack<Integer> result = CollectionsUtil.concatenate(stack1, stack2);

        assertEquals(6, result.size());
        int i = 1;
        while (!result.isEmpty()) {
            assertEquals(i++, result.pop());
        }
    }

    @Test
    public void concatenateStequeTest() {
        final Steque<Integer> steque1 = new Steque<>();
        steque1.push(3);
        steque1.push(2);
        steque1.push(1);

        final Steque<Integer> steque2 = new Steque<>();
        steque2.push(6);
        steque2.push(5);
        steque2.push(4);

        final Steque<Integer> result = CollectionsUtil.concatenate(steque1, steque2);

        assertEquals(6, result.size());

        int i = 1;
        while (!result.isEmpty()) {
            assertEquals(i++, result.pop());
        }
    }
}