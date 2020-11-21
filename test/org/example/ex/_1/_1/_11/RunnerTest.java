package org.example.ex._1._1._11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    void matrixToString() {
        assertEquals("", Runner.matrixToString(null));

        assertEquals("", Runner.matrixToString(new boolean[][]{}));

        ///
        String expectedString = "" +
                "    1 2\n" +
                "   ----\n" +
                " 1| * *\n" +
                " 2| * *\n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{true, true}, {true, true}}));

        ///
        expectedString = "" +
                "    1 2\n" +
                "   ----\n" +
                " 1|    \n" +
                " 2|    \n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{false, false}, {false, false}}));


        ///
        expectedString = "" +
                "    1 2\n" +
                "   ----\n" +
                " 1| * *\n" +
                " 2| * *\n" +
                " 3| * *\n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{true, true}, {true, true}, {true, true}}));

        ///
        expectedString = "" +
                "    1 2\n" +
                "   ----\n" +
                " 1|    \n" +
                " 2|    \n" +
                " 3|    \n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{false, false}, {false, false}, {false, false}}));


        ///
        expectedString = "" +
                "    1 2 3\n" +
                "   ------\n" +
                " 1| * * *\n" +
                " 2| * * *\n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{true, true, true}, {true, true, true}}));

        ///
        expectedString = "" +
                "    1 2 3\n" +
                "   ------\n" +
                " 1|      \n" +
                " 2|      \n";

        assertEquals(expectedString, Runner.matrixToString(new boolean[][]{{false, false, false}, {false, false, false}}));

    }

    @Test
    public void transposedMatrixToString() {
        assertEquals("", Runner.transposedMatrixToString(null));
        assertEquals("", Runner.transposedMatrixToString(new int[][]{}));
        ///
        String expectedString = "" +
                "    1 2\n" +
                "   ----\n" +
                " 1| 1 4\n" +
                " 2| 2 5\n" +
                " 3| 3 6\n";

        assertEquals(expectedString, Runner.transposedMatrixToString(new int[][]{{1, 2, 3}, {4, 5, 6}}));

        ///
        expectedString = "" +
                "    1 2 3\n" +
                "   ------\n" +
                " 1| 1 3 5\n" +
                " 2| 2 4 6\n";

        assertEquals(expectedString, Runner.transposedMatrixToString(new int[][]{{1, 2}, {3, 4,}, {5, 6}}));

    }
}