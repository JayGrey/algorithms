package org.example.ex._1._2._11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartDateTest {
    @Test
    public void test() {
        try {
            new SmartDate(0, 0, 0);
            fail();
        } catch (InvalidDateException ignore) {

        }

        try {
            new SmartDate(29, 2, 2019);
            fail();
        } catch (InvalidDateException ignore) {

        }

        try {
            final SmartDate smartDate = new SmartDate(29, 2, 2020);
            assertEquals(29, smartDate.day());
            assertEquals(2, smartDate.month());
        } catch (InvalidDateException ignore) {

        }
    }

    @Test
    public void dayOfWeekTest() {
        assertEquals("Wednesday", new SmartDate(1, 1, 1800).dayOfTheWeek());
        assertEquals("Tuesday", new SmartDate(21, 1, 1800).dayOfTheWeek());
        assertEquals("Saturday", new SmartDate(8, 3, 1800).dayOfTheWeek());
        assertEquals("Thursday", new SmartDate(1, 1, 1801).dayOfTheWeek());
        assertEquals("Friday", new SmartDate(3, 1, 2020).dayOfTheWeek());
        assertEquals("Monday", new SmartDate(30, 11, 2020).dayOfTheWeek());
        assertEquals("Thursday", new SmartDate(31, 12, 2020).dayOfTheWeek());

    }
}