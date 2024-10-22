package ru.ssau.tk.shnurok.lab2.functions.io;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.operations.TabulatedDifferentialOperator;
import ru.ssau.tk.shnurok.lab2.functions.realizations.LinkedListTabulatedFunction;

import java.io.*;

public class TabulatedFunctionFileInputStream {

    public static void main(String[] args) {
        String filePath = "input/binary function.bin";

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            TabulatedFunction function = FunctionsIO.readTabulatedFunction(inputStream, new ArrayTabulatedFunctionFactory());
            if (function != null) {
                System.out.println("Чтение функции из файла: " + function.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Чтение функции из консоли
        System.out.println("Введите размер и значения функции");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            TabulatedFunctionFactory consoleFactory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction consoleFunction = FunctionsIO.readTabulatedFunction(reader, consoleFactory);

            System.out.println("Функция из консоли: " + consoleFunction.toString());

            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(consoleFactory);
            TabulatedFunction derivative = differentialOperator.derive(consoleFunction);
            System.out.println("Производная функции: " + derivative.toString());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
