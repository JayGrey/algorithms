package org.example.ex._1._3._48;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStacksTest {

    @Test
    public void leftStackPushTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        twoStacks.leftStackPush(1);
        twoStacks.leftStackPush(2);
        twoStacks.leftStackPush(3);

        assertEquals(3, twoStacks.leftStackSize());
        assertEquals(0, twoStacks.rightStackSize());
    }

    @Test
    public void leftStackPopTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        twoStacks.leftStackPush(1);
        twoStacks.leftStackPush(2);
        twoStacks.leftStackPush(3);

        assertEquals(3, twoStacks.leftStackPop());
        assertEquals(2, twoStacks.leftStackPop());
        assertEquals(1, twoStacks.leftStackPop());
        assertEquals(0, twoStacks.leftStackSize());
        assertEquals(0, twoStacks.rightStackSize());
        assertNull(twoStacks.leftStackPop());
    }

    @Test
    public void leftStackSizeTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        assertEquals(0, twoStacks.leftStackSize());

        twoStacks.leftStackPush(1);
        twoStacks.leftStackPush(2);
        twoStacks.leftStackPush(3);
        assertEquals(3, twoStacks.leftStackSize());
        assertEquals(0, twoStacks.rightStackSize());
    }

    @Test
    public void isLeftStackEmptyTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();
        assertTrue(twoStacks.isLeftStackEmpty());

        twoStacks.leftStackPush(1);
        assertFalse(twoStacks.isLeftStackEmpty());

        twoStacks.leftStackPop();
        assertTrue(twoStacks.isLeftStackEmpty());
    }

    @Test
    public void rightStackPushTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        twoStacks.rightStackPush(1);
        twoStacks.rightStackPush(2);
        twoStacks.rightStackPush(3);

        assertEquals(3, twoStacks.rightStackSize());
        assertEquals(0, twoStacks.leftStackSize());
    }

    @Test
    public void rightStackPopTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        twoStacks.rightStackPush(1);
        twoStacks.rightStackPush(2);
        twoStacks.rightStackPush(3);

        assertEquals(3, twoStacks.rightStackPop());
        assertEquals(2, twoStacks.rightStackPop());
        assertEquals(1, twoStacks.rightStackPop());
        assertEquals(0, twoStacks.rightStackSize());
        assertEquals(0, twoStacks.leftStackSize());
        assertNull(twoStacks.rightStackPop());
    }

    @Test
    public void rightStackSizeTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        assertEquals(0, twoStacks.rightStackSize());

        twoStacks.rightStackPush(1);
        twoStacks.rightStackPush(2);
        twoStacks.rightStackPush(3);
        assertEquals(3, twoStacks.rightStackSize());
        assertEquals(0, twoStacks.leftStackSize());
    }

    @Test
    public void isRightStackEmptyTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();
        assertTrue(twoStacks.isRightStackEmpty());

        twoStacks.rightStackPush(1);
        assertFalse(twoStacks.isRightStackEmpty());

        twoStacks.rightStackPop();
        assertTrue(twoStacks.isRightStackEmpty());
    }

    @Test
    public void leftRightTest() {
        final TwoStacks<Integer> twoStacks = new TwoStacks<>();

        twoStacks.leftStackPush(1);
        twoStacks.leftStackPush(2);
        twoStacks.leftStackPush(3);

        assertEquals(3, twoStacks.leftStackSize());
        assertEquals(0, twoStacks.rightStackSize());

        twoStacks.rightStackPush(4);
        twoStacks.rightStackPush(5);
        twoStacks.rightStackPush(6);

        assertEquals(3, twoStacks.leftStackSize());
        assertEquals(3, twoStacks.rightStackSize());

        assertEquals(3, twoStacks.leftStackPop());
        assertEquals(2, twoStacks.leftStackPop());
        assertEquals(6, twoStacks.rightStackPop());
        assertEquals(1, twoStacks.leftStackPop());
        assertEquals(5, twoStacks.rightStackPop());
        assertEquals(4, twoStacks.rightStackPop());
        assertNull(twoStacks.leftStackPop());
        assertNull(twoStacks.rightStackPop());

        assertEquals(0, twoStacks.leftStackSize());
        assertEquals(0, twoStacks.rightStackSize());

    }
}