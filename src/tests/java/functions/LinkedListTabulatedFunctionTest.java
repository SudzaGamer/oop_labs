package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTest {

    @Test
    void testConstructorWithArrays() {
        double[] xValues = {0.0, 0.5, 1.0};
        double[] yValues = {0.0, 0.25, 1.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(0.0, function.getX(0), 1e-10);
        assertEquals(1.0, function.getX(2), 1e-10);
        assertEquals(0.25, function.getY(1), 1e-10);
    }

    @Test
    void testConstructorWithFunction() {
        MathFunction sqr = new SqrFunction();
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(sqr, 0.0, 2.0, 5);

        assertEquals(5, function.getCount());
        assertEquals(0.0, function.getX(0), 1e-10);
        assertEquals(2.0, function.getX(4), 1e-10);
        assertEquals(4.0, function.getY(4), 1e-10);
    }

    @Test
    void testApply() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        // Точные значения
        assertEquals(0.0, function.apply(0.0), 1e-10);
        assertEquals(1.0, function.apply(1.0), 1e-10);
        assertEquals(4.0, function.apply(2.0), 1e-10);

        // Интерполяция
        assertEquals(0.5, function.apply(0.5), 1e-10);
        assertEquals(2.5, function.apply(1.5), 1e-10);

        // Экстраполяция
        assertEquals(-1.0, function.apply(-1.0), 1e-10);
        assertEquals(7.0, function.apply(3.0), 1e-10);
    }

    @Test
    void testSetY() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        function.setY(1, 2.0);
        assertEquals(2.0, function.getY(1), 1e-10);
    }

    @Test
    void testIndexOf() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(1, function.indexOfX(1.0));
        assertEquals(-1, function.indexOfX(3.0));
        assertEquals(2, function.indexOfY(4.0));
        assertEquals(-1, function.indexOfY(3.0));
    }

    @Test
    void testCircularStructure() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);

        // Проверяем циклическую структуру
        assertEquals(0.0, function.getX(0), 1e-10);
        assertEquals(2.0, function.getX(2), 1e-10);
        assertEquals(0.0, function.getX(0), 1e-10); // Должен вернуться к началу
    }

    @Test
    void testRemoveFirst() {
        double[] xValues = {1, 2, 3};
        double[] yValues = {10, 20, 30};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(xValues, yValues);

        fun.remove(0);

        assertEquals(2, fun.getCount());
        assertEquals(2, fun.getX(0), 1e-10);
        assertEquals(3, fun.getX(1), 1e-10);
    }

    @Test
    void testInsertMainCases() {
        LinkedListTabulatedFunction f = new LinkedListTabulatedFunction(
                new double[]{2, 4, 6}, new double[]{20, 40, 60}
        );

        f.insert(1, 10);
        assertEquals(4, f.getCount());
        assertEquals(1, f.getX(0));
        assertEquals(10, f.getY(0));

        f.insert(3, 30);
        assertEquals(5, f.getCount());
        assertEquals(3, f.getX(2));
        assertEquals(30, f.getY(2));

        f.insert(8, 80);
        assertEquals(6, f.getCount());
        assertEquals(8, f.getX(5));
        assertEquals(80, f.getY(5));

        f.insert(4, 400);
        assertEquals(6, f.getCount());
        assertEquals(400, f.getY(3));
    }
}
