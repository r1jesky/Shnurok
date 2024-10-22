package ru.ssau.tk.shnurok.lab2.functions.operations;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.MathFunction;

public interface DifferentialOperator <T extends MathFunction> {
    T derive(T function);
}
