package org.example.ex._1._2._3;

import org.example.ex._1._2._2.Interval1D;

public final class Interval2D {
    private final Interval1D xInterval;
    private final Interval1D yInterval;

    public Interval2D(double x1, double y1, double x2, double y2) {
        xInterval = new Interval1D(x1, x2);
        yInterval = new Interval1D(y1, y2);
    }

    public Interval2D(Point point, double width, double height) {
        this(point.x, point.y, point.x + width, point.y + height);
    }

    public boolean intersects(Interval2D that) {
        return that != null && (xInterval.intersects(that.xInterval) && yInterval.intersects(that.yInterval));
    }

    public boolean contains(Interval2D that) {
        return that != null && xInterval.contains(that.xInterval) && yInterval.contains(that.yInterval);
    }

    @Override
    public String toString() {
        return String.format("Interval2D{%s, %s}", xInterval, yInterval);
    }
}
