package concurrent;

import functions.ArrayTabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {

    @Test
    void testSynchronizedTabulatedFunctionMethods() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {10.0, 20.0, 30.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        TabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);

        assertEquals(function.getCount(), synchronizedFunction.getCount());
        assertEquals(function.getX(1), synchronizedFunction.getX(1));
        assertEquals(function.getY(1), synchronizedFunction.getY(1));

        synchronizedFunction.setY(1, 50.0);
        assertEquals(50.0, synchronizedFunction.getY(1));

        assertEquals(1, synchronizedFunction.indexOfX(1.0));

        assertEquals(50.0, synchronizedFunction.getY(1));

    }
    @Test
    void testIterator() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {10.0, 20.0, 30.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        TabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);

        Iterator<Point> iterator = synchronizedFunction.iterator();

        assertTrue(iterator.hasNext());
        Point firstPoint = iterator.next();
        assertEquals(0.0, firstPoint.x);
        assertEquals(10.0, firstPoint.y);

        assertTrue(iterator.hasNext());
        Point secondPoint = iterator.next();
        assertEquals(1.0, secondPoint.x);
        assertEquals(20.0, secondPoint.y);

        assertTrue(iterator.hasNext());
        Point thirdPoint = iterator.next();
        assertEquals(2.0, thirdPoint.x);
        assertEquals(30.0, thirdPoint.y);

        assertFalse(iterator.hasNext());
    }

    @Test
    void testDoSynchronously() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {10.0, 20.0, 30.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        SynchronizedTabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);

        SynchronizedTabulatedFunction.Operation<Double> sumOperation = new SynchronizedTabulatedFunction.Operation<Double>() {
            @Override
            public Double apply(SynchronizedTabulatedFunction function) {
                double sum = 0;
                for (int i = 0; i < function.getCount(); i++) {
                    sum += function.getY(i);
                }
                return sum;
            }
        };

        Double sum = synchronizedFunction.doSynchronously(sumOperation);
        assertEquals(60.0, sum, "Сумма значений Y должна быть равна 60.0");

        SynchronizedTabulatedFunction.Operation<Void> printOperation = new SynchronizedTabulatedFunction.Operation<Void>() {
            @Override
            public Void apply(SynchronizedTabulatedFunction function) {
                for (int i = 0; i < function.getCount(); i++) {
                    System.out.println("Point " + i + ": X = " + function.getX(i) + ", Y = " + function.getY(i));
                }
                return null;
            }
        };

        synchronizedFunction.doSynchronously(printOperation);
    }
}