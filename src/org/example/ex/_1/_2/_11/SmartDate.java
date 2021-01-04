package org.example.ex._1._2._11;

import java.util.Objects;

public class SmartDate implements Date {
    private final static String FIELD_SEPARATOR = "\\.";
    private final int day;
    private final int month;
    private final int year;
    // 01.01.1800 - wednesday
    private final int PIVOT_YEAR = 1800;
    private final int PIVOT_MONTH = 1;
    private final int PIVOT_DAY = 1;
    private final int PIVOT_DAY_OF_WEEK = 3;

    public SmartDate(int day, int month, int year) {
        checkDate(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static SmartDate of(String dateString) {
        final String[] elements = dateString.trim().split(FIELD_SEPARATOR);
        if (elements.length != 3) {
            throw new InvalidDateException(dateString);
        }

        return new SmartDate(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
    }

    private void checkDate(int day, int month, int year) {
        if (day < 1 || (month < 1 || month > 12) || year < 1800) {
            throw new InvalidDateException(day, month, year);
        }

        if (day > getMaxDays(month, year)) {
            throw new InvalidDateException(day, month, year);
        }
    }

    private int getMaxDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }

    private String getWeekDayByNumber(int number) {
        switch (number) {
            case 0:
                return "Wednesday";
            case 1:
                return "Thursday";
            case 2:
                return "Friday";
            case 3:
                return "Saturday";
            case 4:
                return "Sunday";
            case 5:
                return "Monday";
            case 6:
                return "Tuesday";
            default:
                return "";
        }
    }

    @Override
    public int day() {
        return day;
    }

    @Override
    public int month() {
        return month;
    }

    @Override
    public int year() {
        return year;
    }

    public String dayOfTheWeek() {
        int daysPassed = -1;

        // years
        for (int y = PIVOT_YEAR + 1; y < year(); y++) {
            daysPassed += isLeapYear(y) ? 366 : 365;
        }

        // months
        if (PIVOT_YEAR == year()) {
            for (int m = PIVOT_MONTH; m < month(); m++) {
                daysPassed += getMaxDays(m, year());
            }
        } else {
            daysPassed += isLeapYear(PIVOT_YEAR) ? 366 : 365;
            for (int m = 1; m < month(); m++) {
                daysPassed += getMaxDays(m, year());
            }
        }

        // days
        daysPassed += day();

        return getWeekDayByNumber(daysPassed % 7);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SmartDate smartDate = (SmartDate) o;
        return day == smartDate.day &&
                month == smartDate.month &&
                year == smartDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", day(), month(), year());
    }
}
