package org.example.ex._1._3._3;

public class Runner {

    public static boolean validate(int... validArray) {
        if (validArray == null || validArray.length < 1) {
            throw new IllegalArgumentException();
        }

        final int[] sequence = new int[validArray.length];
        for (int i = 0; i < validArray.length; i++) {
            sequence[i] = i;
        }

        final FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(sequence.length);

        int sequenceIndex = 0;
        int validArrayIndex = 0;
        while (sequenceIndex < sequence.length && validArrayIndex < validArray.length) {

            final int num = validArray[validArrayIndex];
            final int seq = sequence[sequenceIndex];

            if (seq < num) {
                stack.push(seq);
                sequenceIndex++;
            } else if (seq > num) {
                if (stack.pop() != num) {
                    return false;
                }

                validArrayIndex++;
            } else {
                validArrayIndex++;
                sequenceIndex++;
            }
        }

        for (int i = validArrayIndex; i < validArray.length; i++) {
            if (stack.isEmpty() || stack.pop() != validArray[i]) {
                return false;
            }
        }

        return true;
    }
}
