package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantFunctionTest {
    @Test
    void apply() {
        ConstantFunction fun = new ConstantFunction(5.1);

        assertEquals(5.1, fun.apply(1.0));
        assertEquals(5.1, fun.apply(0.0));
        assertEquals(5.1, fun.apply(-2.52));
        assertEquals(5.1, fun.apply(5.2));
        assertEquals(5.1, fun.apply(1234567.89));
    }
}