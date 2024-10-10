package ru.ssau.tk.shnurok.lab2.realizations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTest {
    /* @Test
    public void testInsert() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction();
        function.insert(1, 2);
        assertEquals(1, function.getCount());
        assertEquals(1, function.getX(0));
        assertEquals(2, function.getY(0));

        function.insert(2, 3);
        assertEquals(2, function.getCount());
        function.insert(1.5, 2.5);
        assertEquals(3, function.getCount());
        assertEquals(2.5, function.getY(1)); // Проверка обновления
    }

    @Test
    public void testConstructorWithArrays() {
        double[] xValues = {1, 2, 3};
        double[] yValues = {2, 3, 4};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(3, function.getCount());
        assertEquals(1, function.getX(0));
        assertEquals(2, function.getY(0));
    }

    @Test
    public void testExtrapolateLeft() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2}, new double[]{2, 4});
        assertEquals(0, function.extrapolateLeft(0), 0.01);
    }

    @Test
    public void testExtrapolateRight() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2}, new double[]{2, 4});
        assertEquals(6, function.extrapolateRight(3), 0.01);
    }

    @Test
    public void testFloorIndexOfX() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2, 3}, new double[]{2, 3, 4});
        assertEquals(1, function.floorIndexOfX(2.5));
        assertEquals(0, function.floorIndexOfX(1));
        assertEquals(2, function.floorIndexOfX(4));
    }

    @Test
    public void testGetCount() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction();
        function.insert(1, 2);
        function.insert(2, 3);
        assertEquals(2, function.getCount());
    }

    @Test
    public void testGetX() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2}, new double[]{2, 3});
        assertEquals(1, function.getX(0));
        assertEquals(2, function.getX(1));
    }

    @Test
    public void testGetY() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2}, new double[]{2, 3});
        assertEquals(2, function.getY(0));
        assertEquals(3, function.getY(1));
    }

    @Test
    public void testSetY() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2}, new double[]{2, 3});
        function.setY(0, 5);
        assertEquals(5, function.getY(0));
    }

    @Test
    public void testConstructorWithMathFunction() {
        MathFunction source = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * 2; // Пример функции
            }
        };
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(source, 1, 3, 3);
        assertEquals(3, function.getCount());
        assertEquals(2, function.getY(0)); // При x = 1
        assertEquals(4, function.getY(1)); // При x = 2
        assertEquals(6, function.getY(2)); // При x = 3
    }*/
}