package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroFunctionTest {
    @Test
    void apply() {
        ZeroFunction fun = new ZeroFunction();

        assertEquals(0.0, fun.apply(1.0));
        assertEquals(0.0, fun.apply(0.0));
        assertEquals(0.0, fun.apply(-2.52));
        assertEquals(0.0, fun.apply(5.2));
        assertEquals(0.0, fun.apply(1234567.89));
    }
}