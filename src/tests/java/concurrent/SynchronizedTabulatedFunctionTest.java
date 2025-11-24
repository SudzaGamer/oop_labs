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
        // Создаем обычную табулированную функцию (ArrayTabulatedFunction)
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {10.0, 20.0, 30.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        // Оборачиваем её в SynchronizedTabulatedFunction
        TabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);

        // Проверяем работу методов
        assertEquals(function.getCount(), synchronizedFunction.getCount());
        assertEquals(function.getX(1), synchronizedFunction.getX(1));
        assertEquals(function.getY(1), synchronizedFunction.getY(1));

        // Проверяем установку нового Y-значения
        synchronizedFunction.setY(1, 50.0);
        assertEquals(50.0, synchronizedFunction.getY(1));

        // Проверяем метод indexOfX
        assertEquals(1, synchronizedFunction.indexOfX(1.0));

        // Проверяем метод indexOfY
        assertEquals(50.0, synchronizedFunction.getY(1));

    }
    @Test
    void testIterator() {
        // Создаем обычную табулированную функцию (ArrayTabulatedFunction)
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {10.0, 20.0, 30.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        // Оборачиваем её в SynchronizedTabulatedFunction
        TabulatedFunction synchronizedFunction = new SynchronizedTabulatedFunction(function);

        // Получаем итератор
        Iterator<Point> iterator = synchronizedFunction.iterator();

        // Проверяем, что итератор возвращает правильные значения
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
}