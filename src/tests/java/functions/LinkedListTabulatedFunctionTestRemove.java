package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTestRemove {

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
}