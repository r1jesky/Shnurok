package ru.ssau.tk.shnurok.lab2.functions.operations.implementations;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.MathFunction;
import ru.ssau.tk.shnurok.lab2.functions.operations.abstractclasses.SteppingDifferentialOperator;

public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator {

    public LeftSteppingDifferentialOperator(double step) {
        super(step);
    }


    @Override
    public MathFunction derive(MathFunction function){
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (function.apply(x)-function.apply(x-step))/step;
            }
        };
    }
}
