package io;

import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {

    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {

            double[] x = {0, 1, 2, 3, 4};
            double[] y = {0, 1, 4, 9, 16};
            LinkedListTabulatedFunction f = new LinkedListTabulatedFunction(x, y);

            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();

            TabulatedFunction f1 = differentialOperator.derive(f);
            TabulatedFunction f2 = differentialOperator.derive(f1);

            FunctionsIO.serialize(bos, f);
            FunctionsIO.serialize(bos, f1);
            FunctionsIO.serialize(bos, f2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("output/serialized linked list functions.bin"))) {

            TabulatedFunction df  = FunctionsIO.deserialize(bis);
            TabulatedFunction df1 = FunctionsIO.deserialize(bis);
            TabulatedFunction df2 = FunctionsIO.deserialize(bis);

            System.out.println(df);
            System.out.println(df1);
            System.out.println(df2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
