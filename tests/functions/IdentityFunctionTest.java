package tests.functions;

import main.functions.IdentityFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {

    @Test
    void apply() {
        IdentityFunction fun = new IdentityFunction();

        assertEquals(1.0, fun.apply(1.0), 1e-10);
        assertEquals(0.0, fun.apply(0.0), 1e-10);
        assertEquals(-2.52, fun.apply(-2.52), 1e-10);
        assertEquals(5.2, fun.apply(5.2), 1e-10);
        assertEquals(1234567.89, fun.apply(1234567.89), 1e-10);
    }
}