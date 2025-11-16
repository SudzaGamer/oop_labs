package operations;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionOperationServiceTest {

    @Test
    void asPoints() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        Point[] points = TabulatedFunctionOperationService.asPoints(function);

        assertEquals(3, points.length);

        assertEquals(0.0, points[0].x);
        assertEquals(0.0, points[0].y);

        assertEquals(1.0, points[1].x);
        assertEquals(1.0, points[1].y);

        assertEquals(2.0, points[2].x);
        assertEquals(4.0, points[2].y);
    }

    @Test
    void testAddArrayArray() {
        double[] x = {1, 2, 3};
        double[] y1 = {1, 2, 3};
        double[] y2 = {4, 5, 6};

        TabulatedFunction f1 = new ArrayTabulatedFunction(x, y1);
        TabulatedFunction f2 = new ArrayTabulatedFunction(x, y2);

        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());

        TabulatedFunction result = service.add(f1, f2);

        assertEquals(3, result.getCount());
        assertEquals(5, result.getY(0));
        assertEquals(7, result.getY(1));
        assertEquals(9, result.getY(2));
    }

    @Test
    void testSubtractArrayLinkedList() {
        double[] x = {0, 1, 2};
        double[] y1 = {5, 6, 7};
        double[] y2 = {1, 1, 1};

        TabulatedFunction f1 = new ArrayTabulatedFunction(x, y1);
        TabulatedFunction f2 = new LinkedListTabulatedFunction(x, y2);

        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());

        TabulatedFunction result = service.subtract(f1, f2);

        assertEquals(4, result.getY(0));
        assertEquals(5, result.getY(1));
        assertEquals(6, result.getY(2));
    }

    @Test
    void testInconsistentFunctionsException() {
        double[] x1 = {1, 2, 3};
        double[] y1 = {1, 1, 1};

        double[] x2 = {1, 2};
        double[] y2 = {2, 2};

        TabulatedFunction f1 = new ArrayTabulatedFunction(x1, y1);
        TabulatedFunction f2 = new ArrayTabulatedFunction(x2, y2);

        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService();

        assertThrows(RuntimeException.class, () -> service.add(f1, f2));
    }
}