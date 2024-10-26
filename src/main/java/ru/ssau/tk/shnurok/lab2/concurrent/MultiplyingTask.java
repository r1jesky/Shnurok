package ru.ssau.tk.shnurok.lab2.concurrent;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;

public class MultiplyingTask implements Runnable {

    private final TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public void run() {
        for (int i = 0; i<function.getCount(); i++){
            function.setY(i,function.indexOfY(i)*2);
        }

        System.out.printf("Stream ended work",Thread.currentThread().getName());
    }
}
