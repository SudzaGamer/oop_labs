package functions.factory;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionFactoryTest {

    @Test
    void create() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};

        ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        ArrayTabulatedFunction fun = factory.create(xValues, yValues);

        assertInstanceOf(ArrayTabulatedFunction.class, fun);
    }
}