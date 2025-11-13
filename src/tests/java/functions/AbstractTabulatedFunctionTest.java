package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTabulatedFunctionTest {

    @Test
    void interpolate() {
        MockTabulatedFunction fun = new MockTabulatedFunction();

        assertEquals(6.0, fun.interpolate(1.5, 1.0, 2.0, 4.0, 8.0), 1e-10);
        assertEquals(0.0, fun.interpolate(0.0, 1.0, 2.0, 4.0, 8.0), 1e-10);
        assertEquals(12.0, fun.interpolate(3.0, 1.0, 2.0, 4.0, 8.0), 1e-10);
    }

    @Test
    void apply() {
        MockTabulatedFunction fun = new MockTabulatedFunction();

        assertEquals(4.0, fun.apply(1.0), 1e-10);
        assertEquals(8.0, fun.apply(2.0), 1e-10);           // Проверка на 0
        assertEquals(6.0, fun.apply(1.5), 1e-10);    // Проверка отрицательного числа
        assertEquals(0.0, fun.apply(0.0), 1e-10);          // Проверка дробного числа
        assertEquals(12.0, fun.apply(3.0), 1e-10);          // Проверка дробного числа
    }

    @Test
    void checkLengthIsTheSame() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2};
        assertThrows(DifferentLengthOfArraysException.class, () ->
                AbstractTabulatedFunction.checkLengthIsTheSame(x, y));
    }

    @Test
    void checkSorted() {
        double[] x = {1, 3, 2};
        assertThrows(ArrayIsNotSortedException.class, () ->
                AbstractTabulatedFunction.checkSorted(x));
    }
}