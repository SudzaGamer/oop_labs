package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleIterationSolverTest {

    @Test
    void solve() {
        MathFunction g = Math::cos;
        SimpleIterationSolver cos_solver = new SimpleIterationSolver(g, 1e-6, 100);
        assertEquals(0.739, cos_solver.solve(1.0), 1e-3); // допустимая погрешность

        MathFunction f = (double x) -> x * 2;
        SimpleIterationSolver no_convergence_solver = new SimpleIterationSolver(f, 1e-6, 10);
        assertThrows(RuntimeException.class, () -> {
            no_convergence_solver.solve(1.0);
        });
    }
}