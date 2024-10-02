package ru.ssau.tk.shnurok.lab2.realizations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantFunctionTest {

    @Test
    public void testApply_ReturnsValidConstant(){
        ConstantFunction constantFunction = new ConstantFunction(52);

        assertEquals(52,constantFunction.apply(17));
    }
}