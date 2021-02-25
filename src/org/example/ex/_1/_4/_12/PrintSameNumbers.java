package org.example.ex._1._4._12;

public class PrintSameNumbers {
    public static int search(int[] arrayA, int[] arrayB) {
        if (arrayA == null || arrayB == null) {
            throw new IllegalArgumentException();
        }

        int indexA = 0;
        int indexB = 0;
        int foundNumbers = 0;

        while (indexA < arrayA.length && indexA != -1) {
            int elementA = arrayA[indexA];

            indexB = findElementNotLessThan(arrayB, indexB, elementA);
            if (indexB == -1) {
                break;
            }

            if (elementA == arrayB[indexB]) {
                foundNumbers++;
                indexA = findElementNotLessThan(arrayA, indexA, arrayB[indexB] + 1);
            } else {
                indexA = findElementNotLessThan(arrayA, indexA, arrayB[indexB]);
            }
        }

        return foundNumbers;
    }

    private static int findElementNotLessThan(int[] array, int from, int key) {
        for (int i = from; i < array.length; i++) {
            if (array[i] >= key) {
                return i;
            }
        }
        return -1;
    }
}
