package io;

import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try (
                FileOutputStream arrayStream = new FileOutputStream("output/array function.bin");
                FileOutputStream linkedListStream = new FileOutputStream("output/linked list function.bin");
                BufferedOutputStream bufferedArrayStream = new BufferedOutputStream(arrayStream);
                BufferedOutputStream bufferedLinkedListStream = new BufferedOutputStream(linkedListStream)) {

            TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
            TabulatedFunctionFactory linkedListFactory = new LinkedListTabulatedFunctionFactory();

            double[] xValues = {0.0, 0.5, 1.0, 1.5, 2.0};
            double[] yValues = {0.0, 0.25, 1.0, 2.25, 4.0};

            TabulatedFunction arrayFunction = arrayFactory.create(xValues, yValues);
            TabulatedFunction linkedListFunction = linkedListFactory.create(xValues, yValues);

            FunctionsIO.writeTabulatedFunction(bufferedArrayStream, arrayFunction);
            FunctionsIO.writeTabulatedFunction(bufferedLinkedListStream, linkedListFunction);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}