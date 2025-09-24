package tests.functions;

import main.functions.SqrFunction;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {

    @org.junit.jupiter.api.Test
    void apply() {
        SqrFunction fun = new SqrFunction();

        assertEquals(25.0, fun.apply(5.0), 1e-10);
        assertEquals(0.0, fun.apply(0.0), 1e-10);           // Проверка на 0
        assertEquals(10000.0, fun.apply(-100.0), 1e-10);    // Проверка отрицательного числа
        assertEquals(0.25, fun.apply(0.5), 1e-10);          // Проверка дробного числа
    }
}