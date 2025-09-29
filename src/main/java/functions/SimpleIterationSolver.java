package functions;

public class SimpleIterationSolver {
    private final MathFunction fun;
    private final double tolerance;
    private final int maxIterations;

    public SimpleIterationSolver(MathFunction fun, double tolerance, int maxIterations) {
        this.fun = fun;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    public double solve(double x0) throws RuntimeException {
        double x = x0;
        for (int i = 0; i < maxIterations; i++) {
            double nextX = fun.apply(x);
            if (Math.abs(nextX - x) < tolerance) {
                return nextX;
            }
            x = nextX;
        }
        throw new RuntimeException("Метод не сошелся за " + maxIterations + " итераций.");
    }
}
