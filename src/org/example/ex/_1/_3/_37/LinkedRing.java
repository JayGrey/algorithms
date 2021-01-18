package org.example.ex._1._3._37;

final class LinkedRing {

    private Node currentNode;
    private Node previousNode;

    private int N;

    public LinkedRing(int N) {
        currentNode = createRing(N);
        previousNode = currentNode;

        while (previousNode.next != currentNode) {
            previousNode = previousNode.next;
        }

        this.N = N;
    }

    private Node createRing(int N) {
        Node first = new Node(0, null);
        first.next = first;

        Node last = first;
        for (int i = 1; i < N; i++) {
            last.next = new Node(i, first);
            last = last.next;
        }

        return first;
    }

    public int remove() {
        final int value = N == 0 ? -1 : currentNode.value;

        if (N > 1) {
            currentNode = currentNode.next;
            previousNode.next = currentNode;
        }
        N--;
        return value;
    }

    public void shift(int value) {
        for (int i = 0; i < value; i++) {
            currentNode = currentNode.next;
            previousNode = previousNode.next;
        }

    }

    public int size() {
        return N;
    }

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
