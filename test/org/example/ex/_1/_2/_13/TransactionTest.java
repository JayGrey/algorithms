package org.example.ex._1._2._13;

import org.example.ex._1._2._11.SmartDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void constructorTest() {
        final Transaction transaction = new Transaction("user", new SmartDate(30, 11, 2020), 100.0);

        assertEquals("user", transaction.who());
        assertEquals(new SmartDate(30, 11, 2020), transaction.when());
        assertEquals(100.0, transaction.amount());
    }

    @Test
    public void ofTest() {
        final Transaction transaction = Transaction.of("user | 30.11.2020 | 100.00");
        assertEquals("user", transaction.who());
        assertEquals(new SmartDate(30, 11, 2020), transaction.when());
        assertEquals(100.0, transaction.amount());
    }

    @Test
    public void toStringTest() {
        final Transaction transaction = new Transaction("user", new SmartDate(30, 11, 2020), 100.0);
        assertEquals("user | 30.11.2020 | 100.00", transaction.toString());
    }

    @Test
    public void equalsTest() {
        final Transaction transaction1 = new Transaction("user", new SmartDate(30, 11, 2020), 120.0);
        final Transaction transaction2 = Transaction.of("user | 30.11.2020 | 120.00");
        final Transaction transaction3 = new Transaction("user", new SmartDate(30, 11, 2020), 120.1);

        assertEquals(transaction2, transaction1);
        assertEquals(transaction1, transaction2);

        assertNotEquals(transaction1, transaction3);
        assertNotEquals(transaction3, transaction1);

        assertNotEquals(transaction2, transaction3);
        assertNotEquals(transaction3, transaction2);
    }
}