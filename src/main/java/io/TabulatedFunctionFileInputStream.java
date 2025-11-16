package io;

import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;
import operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (FileInputStream fileStream = new FileInputStream("input/binary function.bin");
             BufferedInputStream bufferedStream = new BufferedInputStream(fileStream)) {

            TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();

            TabulatedFunction function = FunctionsIO.readTabulatedFunction(bufferedStream, arrayFactory);
            System.out.println(function.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Введите размер и значения функции:");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

            LinkedListTabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();

            TabulatedFunction f2 = FunctionsIO.readTabulatedFunction(reader, listFactory);
            TabulatedDifferentialOperator op = new TabulatedDifferentialOperator(listFactory);

            TabulatedFunction derivative = op.derive(f2);

            System.out.println("Производная:");
            System.out.println(derivative);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
