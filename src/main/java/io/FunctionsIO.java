package io;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.TabulatedFunctionFactory;

import java.io.*;

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

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeInt(function.getCount());

        for (Point point : function) {
            dataOutputStream.writeDouble(point.x);
            dataOutputStream.writeDouble(point.y);
        }

        dataOutputStream.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        int count = dataInputStream.readInt();

        double[] xValues = new double[count];
        double[] yValues = new double[count];

        for (int i = 0; i < count; i++) {
            xValues[i] = dataInputStream.readDouble();
            yValues[i] = dataInputStream.readDouble();
        }

        return factory.create(xValues, yValues);
    }
}