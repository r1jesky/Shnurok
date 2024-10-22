package ru.ssau.tk.shnurok.lab2.functions.operations;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.realizations.Point;

public class TabulatedFunctionOperationService {
    static Point[] asPoints(TabulatedFunction tabulatedFunction){
        int count = tabulatedFunction.getCount(); // Получаем количество точек
        Point[] points = new Point[count]; // Инициализируем массив точек

        int i = 0;
        for (Point point : tabulatedFunction) { // Проходим по табулированной функции
            points[i] = point; // Записываем точку в массив
            i++;
        }
        return points; // Возвращаем массив точек
    }
}
