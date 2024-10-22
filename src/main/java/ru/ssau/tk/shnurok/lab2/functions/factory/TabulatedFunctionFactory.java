package ru.ssau.tk.shnurok.lab2.functions.factory;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;

public interface TabulatedFunctionFactory {

    TabulatedFunction create(double[] xValues, double[] yValues);
}
