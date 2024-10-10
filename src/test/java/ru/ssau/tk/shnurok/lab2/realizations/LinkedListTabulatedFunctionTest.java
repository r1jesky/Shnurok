package ru.ssau.tk.shnurok.lab2.realizations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTest {

    @Test
    public void testRemove() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1, 2, 3}, new double[] {4, 5, 6});
        function.remove(1);
        assertEquals(2, function.getCount());
        assertEquals(1, function.getX(0), 0.01);
        assertEquals(4, function.getY(0), 0.01);
        assertEquals(3, function.getX(1), 0.01);
        assertEquals(6, function.getY(1), 0.01);
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
    public void testConstructorWithMathFunction() {
        MathFunction source = x -> x * x; // example math function
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(source, 0, 3, 4);
        assertEquals(4, function.getCount());

        // Проверяем, что количество элементов соответствует ожиданиям
        assertEquals(4, function.count);

        // Check values at x = 1, 2, 3
        assertEquals(1, function.getX(1), 0.01);
        assertEquals(1, function.getY(1), 0.01);

        assertEquals(2, function.getX(2), 0.01);
        assertEquals(4, function.getY(2), 0.01);

        assertEquals(3, function.getX(3), 0.01);
        assertEquals(9, function.getY(3), 0.01);
    }


    @Test
    public void testLeftBound() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1, 2, 3}, new double[] {4, 5, 6});
        assertEquals(1, function.leftBound(), 0.01);
    }

    @Test
    public void testRightBound() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1, 2, 3}, new double[] {4, 5, 6});
        assertEquals(3, function.rightBound(), 0.01);
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
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1, 2, 3}, new double[] {4, 5, 6});
        assertEquals(0, function.floorIndexOfX(0.5));
        assertEquals(0, function.floorIndexOfX(1));
        assertEquals(0, function.floorIndexOfX(1.5));
        assertEquals(1, function.floorIndexOfX(2.5));
        assertEquals(1, function.floorIndexOfX(3));
    }

    @Test
    public void testGetCount() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1, 2, 3}, new double[] {4, 5, 6});
        assertEquals(3, function.getCount());
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
    public void testInsert_Beginning() {
        LinkedListTabulatedFunction func = new LinkedListTabulatedFunction(new double[] {2, 3}, new double[] {20, 30});
        func.insert(1, 10);
        assertEquals(3, func.getCount());
        assertEquals(1, func.getX(0));
        assertEquals(10, func.getY(0));
    }

    @Test
    public void testInsert_Middle() {
        LinkedListTabulatedFunction func = new LinkedListTabulatedFunction(new double[] {1, 3}, new double[] {10, 30});
        func.insert(2, 20);
        assertEquals(3, func.getCount());
        assertEquals(2, func.getX(1));
        assertEquals(20, func.getY(1));
    }

    @Test
    public void testInsert_End() {
        LinkedListTabulatedFunction func = new LinkedListTabulatedFunction(new double[] {1, 2}, new double[] {10, 20});
        func.insert(3, 30);
        assertEquals(3, func.getCount());
        assertEquals(3, func.getX(2));
        assertEquals(30, func.getY(2));
    }
}