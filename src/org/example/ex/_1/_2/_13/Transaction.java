package org.example.ex._1._2._13;

import org.example.ex._1._2._11.SmartDate;

import java.util.Objects;

public class Transaction {

    private static final String FIELD_SEPARATOR = "\\|";

    private final String who;
    private final SmartDate when;
    private final double amount;

    public Transaction(String who, SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public static Transaction of(String transaction) {
        final String[] elements = transaction.trim().split(FIELD_SEPARATOR);
        if (elements.length != 3) {
            throw new IllegalArgumentException(transaction);
        }

        return new Transaction(elements[0].trim(), SmartDate.of(elements[1].trim()), Double.parseDouble(elements[2].trim()));
    }

    public String who() {
        return who;
    }

    public SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %.02f", who(), when(), amount());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != Transaction.class) {
            return false;
        }

        Transaction that = (Transaction) obj;

        return this.who.equals(that.who)
                && this.when.equals(that.when)
                && this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(who, when, amount);
    }
}
