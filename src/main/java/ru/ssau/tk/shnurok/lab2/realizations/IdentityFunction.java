package ru.ssau.tk.shnurok.lab2.realizations;

import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

public class IdentityFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x;
    }
}
