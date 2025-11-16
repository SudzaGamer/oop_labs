package operations;

import functions.ArrayTabulatedFunction;
import functions.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionOperationServiceTest {

    @Test
    void asPoints() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};

        ArrayTabulatedFunction function =
                new ArrayTabulatedFunction(xValues, yValues);

        Point[] points =
                TabulatedFunctionOperationService.asPoints(function);

        assertEquals(3, points.length);

        assertEquals(0.0, points[0].x);
        assertEquals(0.0, points[0].y);

        assertEquals(1.0, points[1].x);
        assertEquals(1.0, points[1].y);

        assertEquals(2.0, points[2].x);
        assertEquals(4.0, points[2].y);
    }
}