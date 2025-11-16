package functions.factory;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;

public class ArrayTabulatedFunctionFactory {
    public ArrayTabulatedFunction create (double[] xValues, double[] yValues){
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
