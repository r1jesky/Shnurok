package ru.ssau.tk.shnurok.lab2;

public class SqrFunction implements MathFunction{

    @Override
    public double apply(double x){
        return Math.pow(x,2);
    }
}