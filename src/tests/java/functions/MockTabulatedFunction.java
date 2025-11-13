package functions;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MockTabulatedFunction extends AbstractTabulatedFunction{
    private final double x0 = 1;
    private final double x1 = 2;

    private final double y0 = 4;
    private final double y1 = 8;

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public double getX(int index) {
        if (index == 0) return 1;
        if (index == 1) return 2;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public double getY(int index) {
        if (index == 0) return 4;
        if (index == 1) return 8;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void setY(int index, double value) {}

    @Override
    public int indexOfX(double x) {
        if (x == 1) return 0;
        if (x == 2) return 1;
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        if (y == 4) return 0;
        if (y == 8) return 1;
        return -1;
    }

    @Override
    public double leftBound(){
        return x0;
    }

    @Override
    public double rightBound(){
        return x1;
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x == 1) return 0;
        if (x == 2) return 1;
        if (x < 1) return 0;
        if (x < 2) return 0;
        return 2;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, x0, x1, y0, y1);
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < getCount();
            }

            @Override
            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more points in the tabulated function");
                }
                Point point = new Point(getX(currentIndex), getY(currentIndex));
                currentIndex++;
                return point;
            }
        };
    }

}
