package org.example.ex._1._5._18;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._2._3.Point;
import org.example.ex._1._3._34.RandomBag;
import org.example.ex._1._5._7.UF;
import org.example.ex._1._5._7.WeightedQuickUnionUF;

import java.awt.*;

public class RandomGrid {
    private static final int X_PADDING = 10;
    private static final int Y_PADDING = 10;

    private static Connection[] generate(int N) {
        final RandomBag<Connection> connections = new RandomBag<>();

        for (int p = 0; p < N; p++) {
            for (int q = p + 1; q < N; q++) {
                if (StdRandom.bernoulli()) {
                    connections.add(new Connection(p, q));
                } else {
                    connections.add(new Connection(q, p));
                }
            }
        }

        Connection[] result = new Connection[connections.size()];
        int i = 0;
        for (Connection connection : connections) {
            result[i++] = connection;
        }

        return result;
    }

    public static void main(String[] args) {
        StdOut.print("N: ");
        final int N = StdIn.readInt();

        final Connection[] connections = generate(N);

        final UF uf = new WeightedQuickUnionUF(N);

        StdDraw.setXscale(100, 0);
        StdDraw.setYscale(100, 0);

        for (Connection connection : connections) {
            if (!uf.connected(connection.p, connection.q)) {
                uf.union(connection.p, connection.q);
                drawForest(uf.connections());
                StdDraw.pause(200);
            }
        }
//        StdOut.println(uf);
    }

    private static void drawForest(int[] connections) {
        StdDraw.clear();
        Point lastPosition = new Point(X_PADDING, Y_PADDING);
        final double yPosition = lastPosition.y;
        for (int i = 0; i < connections.length; i++) {
            if (i == connections[i]) {
                drawPoint(new Point(lastPosition.x, yPosition), i);
                lastPosition = drawTree(connections, i, lastPosition);
                lastPosition = new Point(lastPosition.x + X_PADDING, yPosition);
            }
        }
    }

    private static Point drawTree(int[] connections, int rootIndex, Point rootPosition) {
        Point lastPosition = new Point(rootPosition.x, rootPosition.y + Y_PADDING);
        final double yPosition = lastPosition.y;

        for (int i = 0; i < connections.length; i++) {

            if (connections[i] == rootIndex && i != rootIndex) {
                drawPoint(new Point(lastPosition.x, yPosition), i);
                drawLine(rootPosition, new Point(lastPosition.x, yPosition));
      /*          StdOut.printf("r[%d](%f, %f), c[%d](%f, %f)%n", rootIndex, rootPosition.x, rootPosition.y,
                        i, lastPosition.x, yPosition);*/
                lastPosition = drawTree(connections, i, new Point(lastPosition.x, yPosition));
            }
        }

        return new Point(lastPosition.x + X_PADDING, lastPosition.y);
    }

    private static void drawLine(Point p1, Point p2) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(p1.x, p1.y, p2.x, p2.y);
    }

    private static void drawPoint(Point position, int nodeNumber) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.02);
        StdDraw.point(position.x, position.y);
        StdDraw.text(position.x - 2, position.y + 2, "" + nodeNumber);
    }
}
