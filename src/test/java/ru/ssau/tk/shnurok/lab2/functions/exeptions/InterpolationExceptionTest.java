package ru.ssau.tk.shnurok.lab2.functions.exeptions;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.shnurok.lab2.exeptions.InterpolationException;

import static org.junit.jupiter.api.Assertions.*;

class InterpolationExceptionTest {

    @Test
    void testDefaultConstructor() {
        InterpolationException exception = new InterpolationException();
        assertNull(exception.getMessage(), "Сообщение исключения должно быть null");
    }

    @Test
    void testConstructorWithMessage() {
        String message = "Ошибка интерполяции";
        InterpolationException exception = new InterpolationException(message);
        assertEquals(message, exception.getMessage(), "Сообщение исключения не совпадает с ожидаемым");
    }
}

