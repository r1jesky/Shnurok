package ru.ssau.tk.shnurok.lab2.concurrent;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.realizations.LinkedListTabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.realizations.UnitFunction;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyingTaskExecutorTest {
    private MultiplyingTaskExecutor multiplyingTaskExecutor;
    private TabulatedFunction tabulatedFunction;

    @Test
    public void testMultiplyingTaskExecutor() throws InterruptedException{
        double multiplier = 2;
        tabulatedFunction = new LinkedListTabulatedFunction(new double[] {1,2,3,4,5},new double[]{1,2,3,4,5});
        multiplyingTaskExecutor = new MultiplyingTaskExecutor();
        for(int i =0; i<tabulatedFunction.getCount();i++){
            tabulatedFunction.setY(i,tabulatedFunction.getY(i)*multiplier);
        }

        multiplyingTaskExecutor.main(new String[] {});

        for (int i = 0; i < tabulatedFunction.getCount(); i++){
            assertEquals(tabulatedFunction.getY(i),
                    tabulatedFunction.getX(i)*2);
        }
    }
}