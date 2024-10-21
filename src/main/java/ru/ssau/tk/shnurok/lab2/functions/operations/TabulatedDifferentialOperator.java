package ru.ssau.tk.shnurok.lab2.functions.operations;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.shnurok.lab2.functions.realizations.Point;

public class TabulatedDifferentialOperator implements DifferentialOperator <TabulatedFunction>{

    private TabulatedFunctionFactory factory;

    // Конструктор по умолчанию
    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    // Конструктор с фабрикой
    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    // Геттер для фабрики
    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    // Сеттер для фабрики
    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        return null;
    }
    /*
    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        // Получаем точки входной функции
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        int count = points.length;

        double[] xValues = new double[count - 1];
        double[] yValues = new double[count - 1];

        // Вычисляем численную производную
        for (int i = 0; i < count - 1; i++) {
            xValues[i] = points[i].getX();
            yValues[i] = (points[i + 1].getY() - points[i].getY()) / (points[i + 1].getX() - points[i].getX());
        }

        // Создаем новый экземпляр табулированной функции
        return factory.create(xValues, yValues);
    }*/
}
