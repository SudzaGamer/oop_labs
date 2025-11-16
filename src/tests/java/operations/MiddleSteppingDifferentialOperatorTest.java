package operations;

import functions.MathFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleSteppingDifferentialOperatorTest {

    @Test
    void derive() {
        double step = 1e-4;
        MiddleSteppingDifferentialOperator op = new MiddleSteppingDifferentialOperator(step);

        MathFunction f = new SqrFunction();
        MathFunction df = op.derive(f);

        double x = 2.0;
        double expected = 2 * x;
        double actual = df.apply(x);

        assertEquals(expected, actual, 1e-5);
    }
}