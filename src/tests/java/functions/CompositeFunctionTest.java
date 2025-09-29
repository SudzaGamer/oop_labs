package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    @Test
    void SimpleComposTest() {
        MathFunction sqr = new SqrFunction();
        MathFunction iden = new IdentityFunction();

        CompositeFunction Comp1 = new CompositeFunction(iden, sqr);
        CompositeFunction Comp2 = new CompositeFunction(sqr, sqr);
        CompositeFunction Comp3 = new CompositeFunction(Comp1, Comp2);



        assertEquals(25, Comp1.apply(5), 1e-10); // g(x) = sqr(id(x))
        assertEquals(81, Comp2.apply(3), 1e-10); // k(x) = sqr(sqr(x))
        assertEquals(256, Comp3.apply(2), 1e-10); // h(x) = k(g(x))

    }
}