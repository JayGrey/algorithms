package org.example.ex._1._1._21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static String format(List<String> lines) {
        class Record {
            final String name;
            final int a;
            final int b;
            final double ratio;

            public Record(String name, int a, int b) {
                this.name = name;
                this.a = a;
                this.b = b;
                this.ratio = (double) a / b;
            }
        }

        final ArrayList<Record> records = new ArrayList<>();

        int maxName = 1;
        int maxA = 1;
        int maxB = 1;
        int maxRatio = 1;

        for (String line : lines) {
            final String[] tokens = line.split("\\s+");
            if (tokens.length < 3) {
                continue;
            }

            final Record record = new Record(tokens[0].trim(),
                    Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));

            maxName = Math.max(maxName, record.name.length());
            maxA = (int) Math.max(maxA, Math.round(Math.log10(record.a)));
            maxB = (int) Math.max(maxB, Math.round(Math.log10(record.b)));
            maxRatio = (int) Math.max(maxRatio, Math.round(Math.log10(record.ratio)));

            records.add(record);
        }

        final String format = "%-" + maxName + "s  " +
                "%" + (maxA + 1) + "d  " +
                "%" + (maxB + 1) + "d  " +
                "%" + (maxRatio + 2) + ".3f";

        return records.stream()
                .map(r -> String.format(format, r.name, r.a, r.b, r.ratio))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static void main(String[] args) {
        final List<String> lines = new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .collect(Collectors.toList());

        System.out.println(format(lines));
    }
}
