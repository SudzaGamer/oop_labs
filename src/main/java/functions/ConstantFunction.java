package functions;

public class ConstantFunction implements MathFunction {
    private final double constant;

    public ConstantFunction(double cons) {
        constant = cons;
    }

    @Override
    public double apply(double x){
        return constant;
    }
}
