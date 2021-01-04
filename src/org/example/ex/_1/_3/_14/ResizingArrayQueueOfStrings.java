package org.example.ex._1._3._14;

public class ResizingArrayQueueOfStrings implements Queue<String> {
    private int N;
    private String[] array = new String[8];

    @Override
    public void enqueue(String s) {
        if (N == array.length - 1) {
            final String[] tmp = new String[array.length * 2];
            System.arraycopy(array, 0, tmp, 0, N);
            array = tmp;
        }
        array[N++] = s;
    }

    @Override
    public String dequeue() {
        String item = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = null;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}
