package io;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.TabulatedFunctionFactory;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        try {
            String line = reader.readLine();
            int count = Integer.parseInt(line);

            double[] xValues = new double[count];
            double[] yValues = new double[count];

            NumberFormat formatter = NumberFormat.getInstance(Locale.forLanguageTag("ru"));

            for (int i = 0; i < count; i++) {
                line = reader.readLine();
                if (line == null) {
                    throw new IOException("Unexpected end of file");
                }

                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    throw new IOException("Invalid line format: " + line);
                }

                try {
                    xValues[i] = formatter.parse(parts[0]).doubleValue();
                    yValues[i] = formatter.parse(parts[1]).doubleValue();
                } catch (ParseException e) {
                    throw new IOException("Failed to parse number", e);
                }
            }

            return factory.create(xValues, yValues);

        } catch (NumberFormatException e) {
            throw new IOException("Failed to parse count of points", e);
        }
    }

}