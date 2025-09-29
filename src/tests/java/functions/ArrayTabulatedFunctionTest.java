package functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    @Test
    void testConstructorWithArrays() {
        double[] xValues = {0.0, 0.5, 1.0};
        double[] yValues = {0.0, 0.25, 1.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(3, function.getCount());
        assertEquals(0.0, function.getX(0), 1e-10);
        assertEquals(1.0, function.getX(2), 1e-10);
        assertEquals(0.25, function.getY(1), 1e-10);
    }

    @Test
    void testConstructorWithFunction() {
        MathFunction sqr = new SqrFunction();
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(sqr, 0.0, 2.0, 5);

        assertEquals(5, function.getCount());
        assertEquals(0.0, function.getX(0), 1e-10);
        assertEquals(2.0, function.getX(4), 1e-10);
        assertEquals(4.0, function.getY(4), 1e-10);
    }

    @Test
    void testApply() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

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
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        function.setY(1, 2.0);
        assertEquals(2.0, function.getY(1), 1e-10);
    }

    @Test
    void testIndexOf() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(1, function.indexOfX(1.0));
        assertEquals(-1, function.indexOfX(3.0));
        assertEquals(2, function.indexOfY(4.0));
        assertEquals(-1, function.indexOfY(3.0));
    }
}
