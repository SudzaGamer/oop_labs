package io;

import functions.Point;
import functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.PrintWriter;

public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        PrintWriter printWriter = new PrintWriter(writer);
        int count = function.getCount();
        printWriter.println(count); // первая строка - количество точек

        for (Point p : function) {
            printWriter.printf("%f %f%n", p.x, p.y); // x и y через пробел
        }

        printWriter.flush(); // проброс всех данных в буфер
    }
}