package main.functions;

class IdentityFunction implements MathFunction {
    @Override
    public double apply(double x){
        return x;
    }
}
