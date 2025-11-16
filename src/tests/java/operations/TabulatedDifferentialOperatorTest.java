package operations;

import functions.TabulatedFunction;
import functions.factory.LinkedListTabulatedFunctionFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabulatedDifferentialOperatorTest {

    @Test
    public void testDeriveWithArrayFactory() {

        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();

        double[] xValues = {0, 1, 2, 3, 4};
        double[] yValues = {0, 2, 4, 6, 8};
        TabulatedFunction function = operator.getFactory().create(xValues, yValues);

        TabulatedFunction derivative = operator.derive(function);

        for (int i = 0; i < derivative.getCount(); i++) {
            assertEquals(2.0, derivative.getY(i), 1e-10);
        }
    }

    @Test
    public void testDeriveRightDifference() {
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();

        double[] xValues = {0, 1, 2, 3};
        double[] yValues = {0, 1, 4, 9};

        TabulatedFunction function = operator.getFactory().create(xValues, yValues);
        TabulatedFunction derivative = operator.derive(function);

        assertEquals(1.0, derivative.getY(0), 1e-10);
        assertEquals(3.0, derivative.getY(1), 1e-10);
        assertEquals(5.0, derivative.getY(2), 1e-10);

        assertEquals(5.0, derivative.getY(3), 1e-10);
    }

    @Test
    public void testDeriveWithLinkedListFactory() {
        TabulatedDifferentialOperator operator =
                new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());

        double[] xValues = {0, 0.5, 1.5, 2.0};
        double[] yValues = {0, 0.25, 2.25, 4.0};

        TabulatedFunction function = operator.getFactory().create(xValues, yValues);
        TabulatedFunction derivative = operator.derive(function);

        assertEquals(0.5, derivative.getY(0), 1e-10);
        assertEquals(2.0, derivative.getY(1), 1e-10);
        assertEquals(3.5, derivative.getY(2), 1e-10);
        assertEquals(3.5, derivative.getY(3), 1e-10);
    }

    @Test
    public void testDeriveConstantFunction() {
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();

        double[] xValues = {0, 1, 2, 3};
        double[] yValues = {5, 5, 5, 5};
        TabulatedFunction function = operator.getFactory().create(xValues, yValues);

        TabulatedFunction derivative = operator.derive(function);

        for (int i = 0; i < derivative.getCount(); i++) {
            assertEquals(0.0, derivative.getY(i), 1e-10);
        }
    }

    @Test
    public void testTwoPointFunction() {
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();

        double[] xValues = {1.0, 3.0};
        double[] yValues = {2.0, 8.0};

        TabulatedFunction function = operator.getFactory().create(xValues, yValues);
        TabulatedFunction derivative = operator.derive(function);

        assertEquals(3.0, derivative.getY(0), 1e-10);
        assertEquals(3.0, derivative.getY(1), 1e-10);
    }
}