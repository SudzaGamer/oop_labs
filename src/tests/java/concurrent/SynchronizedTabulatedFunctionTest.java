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
}