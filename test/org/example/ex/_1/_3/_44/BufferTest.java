package org.example.ex._1._3._44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    @Test
    public void insert1Test() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        assertEquals(1, buffer.size());
        assertEquals("a", buffer.toString());
    }

    @Test
    public void insert2Test() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.right(1);

        buffer.insert('b');
        buffer.right(1);

        buffer.insert('c');
        buffer.right(2);

        assertEquals(3, buffer.size());
        assertEquals("abc", buffer.toString());
    }

    @Test
    public void delete1Test() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.right(1);

        buffer.insert('b');
        buffer.right(1);

        buffer.insert('c');
        buffer.right(1);

        assertEquals(3, buffer.size());
        assertEquals("abc", buffer.toString());

        buffer.left(2);
        assertEquals('b', buffer.delete());

        assertEquals(2, buffer.size());
        assertEquals("ac", buffer.toString());
    }

    @Test
    public void delete2Test() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        assertEquals(1, buffer.size());

        buffer.left(1);
        assertEquals('a', buffer.delete());
        assertEquals(0, buffer.size());
    }

    @Test
    public void leftTest() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.left(1);
        buffer.insert('b');

        assertEquals("ba", buffer.toString());
    }

    @Test
    public void rightTest() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.insert('b');
        buffer.left(2);
        buffer.right(1);
        buffer.insert('c');

        assertEquals("acb", buffer.toString());

    }

    @Test
    public void sizeTest() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.insert('b');
        assertEquals(2, buffer.size());

        buffer.left(2);
        buffer.delete();
        buffer.delete();
        assertEquals(0, buffer.size());
    }

    @Test
    public void toStringTest() {
        final Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');

        assertEquals("abc", buffer.toString());
    }
}