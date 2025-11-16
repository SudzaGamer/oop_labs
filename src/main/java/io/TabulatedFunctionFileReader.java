package io;

import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {

    public static void main(String[] args) {
        try (
                BufferedReader readerArray = new BufferedReader(new FileReader("input/function.txt"));
                BufferedReader readerLinked = new BufferedReader(new FileReader("input/function.txt"))
        ) {
            // Чтение с использованием разных фабрик
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(readerArray, new ArrayTabulatedFunctionFactory());
            TabulatedFunction linkedFunction = FunctionsIO.readTabulatedFunction(readerLinked, new LinkedListTabulatedFunctionFactory());

            // Вывод в консоль
            System.out.println("ArrayTabulatedFunction:");
            System.out.println(arrayFunction);

            System.out.println("LinkedListTabulatedFunction:");
            System.out.println(linkedFunction);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
