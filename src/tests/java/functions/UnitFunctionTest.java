package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitFunctionTest {
    @Test
    void apply() {
        UnitFunction fun = new UnitFunction();

        assertEquals(1.0, fun.apply(1.0));
        assertEquals(1.0, fun.apply(0.0));
        assertEquals(1.0, fun.apply(-2.52));
        assertEquals(1.0, fun.apply(5.2));
        assertEquals(1.0, fun.apply(1234567.89));
    }
}