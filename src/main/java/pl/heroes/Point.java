package pl.heroes;

import java.util.Objects;

public class Point {
    final private int x;
    final private int y;

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
