package ru.ssau.tk.shnurok.lab2.coredefenitions;

import ru.ssau.tk.shnurok.lab2.realizations.CompositeFunction;

public interface MathFunction {
    double apply(double x);

    default CompositeFunction andThen(MathFunction  afterFunction){
        return  new CompositeFunction(this, afterFunction);
    }
    
}