package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionTest {

    @Test
    void andThen() {
        MathFunction c = new ConstantFunction(3);
        MathFunction sqr = new SqrFunction();
        MathFunction iter = new SimpleIterationSolver(Math::cos, 1e-6, 100);

        assertEquals(9.0, iter.andThen(c).andThen(sqr).apply(1));
        assertEquals(9.0, iter.andThen(c).andThen(sqr).apply(0.5));

        assertEquals(0.739, sqr.andThen(c).andThen(iter).apply(0.5), 1e-3);

        assertEquals(3.0, sqr.andThen(iter).andThen(c).apply(20));
        assertEquals(3.0, sqr.andThen(iter).andThen(c).apply(0.2));
    }
}