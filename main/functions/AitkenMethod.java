package main.functions;

import org.junit.jupiter.api.Test;

public class AitkenMethod implements MathFunction {          //Формула: XAitken = x2 - ((x2 - x1)2 / ((x2 - x1) - (x1 - x2)))
    private static final double TOLERANCE = 1e-10;
    private static final double EPS = 1e-16;
    private static final int MAX_ITERATIONS = 33;

    @Override
    public double apply(double x0) {
        boolean SolutionIsFounded = false;
        double XAitken = x0;

        for (int i = 0; i < MAX_ITERATIONS; i++) {        // f(x) = (1/2) * (x + 2/x)
            double x1 = 0.5 * (x0 + 2 / x0);
            double x2 = 0.5 * (x1 + 2 / x1);

            double denominator = (x2 - x1) - (x1 - x0);

            if (Math.abs(denominator) < EPS) {
                System.out.println("Error: Denominator is too small");
                break;
            }

            XAitken = x2 - Math.pow(x2 - x1, 2) / denominator;

            if (Math.abs(XAitken - x2) < TOLERANCE) {
                SolutionIsFounded = true;
                break;
            }
            x0 = XAitken; // обновляем x0
        }
        if (!SolutionIsFounded) {
            System.out.println("Error: Not able to find solution to within the desired tolerance of " + TOLERANCE);
            System.out.println("The last computed extrapolate was " + XAitken);
        }
        return XAitken;
    }
}