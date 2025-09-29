package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AitkenMethodTest {

    @Test
    void AitkenMethod() {

        AitkenMethod fun = new AitkenMethod();

        assertEquals(Math.sqrt(2), fun.apply(1.0), 1e-10);
    }
}