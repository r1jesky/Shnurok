package ru.ssau.tk.shnurok.lab2.functions.io;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.realizations.Point;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException{
        String line = reader.readLine();
        int count = Integer.parseInt(line.trim());

        double[] xValues = new double[count];
        double[] yValues = new double[count];

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));

        for (int i = 0; i<count; i++){
            try{
                line = reader.readLine();
                String[] parts = line.split(" ");
                xValues[i] = numberFormat.parse(parts[0]).doubleValue();
                yValues[i] = numberFormat.parse(parts[0]).doubleValue();
            } catch (ParseException parseException){
                throw new IOException(parseException);
            }
        }

        return factory.create(xValues,yValues);
    }
}
