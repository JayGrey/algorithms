package org.example.ex._1._2._11;

public class InvalidDateException extends RuntimeException {

    public InvalidDateException(int day, int month, int year) {
        super(String.format("Date [dd/mm/yyyy] %d / %d / %d is illegal", day, month, year));
    }

    public InvalidDateException(String date) {
        super(String.format("Date %s is illegal", date));
    }
}
