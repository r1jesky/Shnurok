package ru.ssau.tk.shnurok.lab2.functions.io;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.realizations.Point;

import java.io.*;

public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException("Cannot instantiate this class");
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function){
        try(PrintWriter printWriter = new PrintWriter(writer)){
            printWriter.println(function.getCount());
            for (Point point : function){
                printWriter.printf("%f %f%n", point.getX(), point.getY());
            }

            writer.flush();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }


    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
         try (DataOutputStream dos = new DataOutputStream(outputStream)) {
             dos.writeInt(function.getCount());
             for (Point point : function){
                 dos.writeDouble(point.getX());
                 dos.writeDouble(point.getY());
             }
             dos.flush();
         }
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) {
        try (DataInputStream dis = new DataInputStream(inputStream)) {
            int size = dis.readInt();
            double[] xValues = new double[size];
            double[] yValues = new double[size];

            for (int i = 0; i < size; i++) {
                xValues[i] = dis.readDouble();
                yValues[i] = dis.readDouble();
            }

            return factory.create(xValues, yValues);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
