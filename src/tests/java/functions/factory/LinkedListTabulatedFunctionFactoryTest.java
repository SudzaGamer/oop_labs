package functions.factory;

import functions.LinkedListTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionFactoryTest {

    @Test
    void create() {
        double[] xValues = {0.0, 1.0, 2.0};
        double[] yValues = {0.0, 1.0, 4.0};

        LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        LinkedListTabulatedFunction fun = factory.create(xValues, yValues);

        assertInstanceOf(LinkedListTabulatedFunction.class, fun);
    }
}