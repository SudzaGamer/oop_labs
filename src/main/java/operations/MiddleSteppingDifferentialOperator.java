package operations;

import functions.MathFunction;

public class MiddleSteppingDifferentialOperator extends SteppingDifferentialOperator {

    public MiddleSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction f) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (f.apply(x + step) - f.apply(x - step)) / (2 * step);
            }
        };
    }
}