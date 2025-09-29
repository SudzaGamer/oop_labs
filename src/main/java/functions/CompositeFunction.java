package functions;

public class CompositeFunction implements MathFunction {

    private final MathFunction firstFun;
    private final MathFunction secondFun;

    public CompositeFunction(MathFunction first, MathFunction second){
        this.firstFun = first;
        this.secondFun = second;
    }

    @Override
    public double apply(double x) {
        return secondFun.apply(firstFun.apply(x));
    }
}
