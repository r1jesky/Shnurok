package ru.ssau.tk.shnurok.lab2.functions.io;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.factory.TabulatedFunctionFactory;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;

public class TabulatedFunctionFileReader {
    public static void main(String[] args){
        Path path = Paths.get("input","function.txt");

        try (BufferedReader arrFileReader = new BufferedReader(
                new FileReader(path.toAbsolutePath().toString())
        );
             BufferedReader lListReader = new BufferedReader(
                     new FileReader(path.toAbsolutePath().toString())
             )
        ){
            TabulatedFunctionFactory arrFactory = new ArrayTabulatedFunctionFactory();
            TabulatedFunctionFactory lListFactory = new LinkedListTabulatedFunctionFactory();

            TabulatedFunction arrFunction = FunctionsIO.readTabulatedFunction(arrFileReader,arrFactory);
            TabulatedFunction lListFunction = FunctionsIO.readTabulatedFunction(lListReader,arrFactory);

            System.out.println(arrFunction.toString());
            System.out.println(lListFunction.toString());
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
