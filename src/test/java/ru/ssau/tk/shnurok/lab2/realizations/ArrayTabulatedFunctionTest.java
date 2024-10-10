package ru.ssau.tk.shnurok.lab2.realizations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayTabulatedFunctionTest {

    @Test
    void floorIndexOfX() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(2,arrayTabulatedFunction.floorIndexOfX(3.5));
        assertEquals(1,arrayTabulatedFunction.floorIndexOfX(2.75));
        assertEquals(0,arrayTabulatedFunction.floorIndexOfX(-1));
    }

    @Test
    void extrapolateLeft() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(-4,arrayTabulatedFunction.extrapolateRight(-1));
    }

    @Test
    void extrapolateRight() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(14,arrayTabulatedFunction.extrapolateRight(5));
    }

    @Test
    void interpolate() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(5,arrayTabulatedFunction.interpolate(2, arrayTabulatedFunction.floorIndexOfX(2)));
    }

    @Test
    void getCount() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(3,arrayTabulatedFunction.getCount());
    }

    @Test
    void getX() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(2,arrayTabulatedFunction.getX(1));

    }

    @Test
    void getY() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(5,arrayTabulatedFunction.getY(1));
    }

    @Test
    void setY_Test() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);
        arrayTabulatedFunction.setY(0,52);
        assertEquals(52,arrayTabulatedFunction.getY(0));
    }

    @Test
    void indexOfX() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(1,arrayTabulatedFunction.indexOfX(2));
    }

    @Test
    void indexOfY() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(1,arrayTabulatedFunction.indexOfY(5));
    }

    @Test
    void leftBound() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(1,arrayTabulatedFunction.leftBound());
    }

    @Test
    void rightBound() {
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);

        assertEquals(3,arrayTabulatedFunction.rightBound());
    }

    @Test
    void InserTest(){
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);
        arrayTabulatedFunction.insert(1.5,4.);

        assertEquals(1.5,arrayTabulatedFunction.getX(0));
    }

    @Test
    void RemoveTest(){
        double[] xVal = {1.,2.,3.};
        double[] yVal = {2.,5.,8.};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xVal,yVal);
        arrayTabulatedFunction.remove(1);

        assertEquals(3,arrayTabulatedFunction.getX(arrayTabulatedFunction.xValues.length-1));
    }
}