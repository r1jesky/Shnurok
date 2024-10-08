package ru.ssau.tk.shnurok.lab2.realizations;


import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

public class ConstantFunction implements MathFunction {

    private final double constant;

    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    @Override
    public double apply(double x) {
        return constant;
    }

    public double getConstant() {
        return constant;
    }
}