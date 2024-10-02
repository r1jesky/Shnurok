package ru.ssau.tk.shnurok.lab2.realizations;

import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

public class NewtonMethodFunction implements MathFunction {

    private final static double EPS  = 1E-7;
    private final MathFunction function;
    private final double tolerance;

    public NewtonMethodFunction(MathFunction function, double tolerance) {
        this.function = function;
        this.tolerance = tolerance;
    }
    private double derivative(double x) {
        return function.apply(x + EPS) / EPS / 2 - function.apply(x - EPS) / EPS / 2;
    }

    @Override
    public double apply(double x) {
        double xn;
        for (int i = 0; i < 1000000; i++) {
            double f = function.apply(x);
            double pr_f = derivative(x);

            if (Math.abs(pr_f) < tolerance) break;

            xn = x - f / pr_f;

            if (Math.abs(xn - x) < tolerance) {
                return xn;
            }

            x = xn;
        }

        return Double.NaN; // function does not converge to zero
    }
}
