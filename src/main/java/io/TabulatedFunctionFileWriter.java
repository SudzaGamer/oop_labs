package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        try (
                BufferedWriter writerArray = new BufferedWriter(new FileWriter("output/array function.txt"));
                BufferedWriter writerLinked = new BufferedWriter(new FileWriter("output/linked list function.txt"))
        ) {
            // Создаём две функции
            double[] xValues = {0, 1, 2, 3};
            double[] yValues1 = {0, 1, 4, 9}; // массив
            double[] yValues2 = {0, 2, 8, 18}; // связный список

            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues1);
            TabulatedFunction linkedFunction = new LinkedListTabulatedFunction(xValues, yValues2);

            // Записываем функции в файлы
            FunctionsIO.writeTabulatedFunction(writerArray, arrayFunction);
            FunctionsIO.writeTabulatedFunction(writerLinked, linkedFunction);

            System.out.println("Файлы успешно записаны в папку output");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
