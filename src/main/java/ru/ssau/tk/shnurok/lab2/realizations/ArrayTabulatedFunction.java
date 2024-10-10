package ru.ssau.tk.shnurok.lab2.realizations;

import ru.ssau.tk.shnurok.lab2.coredefenitions.AbstractTabulatedFunction;
import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    protected double[] xValues;
    protected double[] yValues;
    protected int count;


    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length!=yValues.length) throw new IllegalArgumentException("raznoe(");

        this.count = xValues.length;
        this.xValues = Arrays.copyOf(xValues,xValues.length);
        this.yValues = Arrays.copyOf(yValues,yValues.length);

    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {

        if (xFrom > xTo){
            double tmp = xFrom;
            xFrom = xTo;
            xTo = tmp;
        }

        this.count = count;
        this.xValues = new double[count];
        this.yValues = new double[count];

        if(xFrom == xTo){
            Arrays.fill(xValues,xFrom);
            Arrays.fill(yValues,source.apply(xFrom));
        } else {
            double step = (xTo - xFrom) / (count - 1);
            for (int i = 0; i < count; i++) {
                xValues[i] = xFrom + i*step;
                yValues[i] = source.apply(xValues[i]);
            }
        }

    }

    @Override
    protected int floorIndexOfX(double x) {
        if(x<xValues[0]) return 0;
        else if(x >= xValues[count-1]) return count-1;
        for(int i = 1; i<count;i++){
            if (xValues[i]>x)return i-1;
        }
        return count-1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x,xValues[0],xValues[1],yValues[0],yValues[1]);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x,xValues[count-2],xValues[count-1],yValues[count-2],yValues[count-1]);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return interpolate(x,xValues[floorIndex],xValues[floorIndex+1],yValues[floorIndex],yValues[floorIndex+1]);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return xValues[index];
    }

    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i<xValues.length;i++){
            if (xValues[i] == x) return i;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i<yValues.length; i++){
            if (yValues[i] == y) return i;
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[xValues.length-1];
    }
}