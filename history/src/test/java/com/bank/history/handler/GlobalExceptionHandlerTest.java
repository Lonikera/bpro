package com.bank.history.handler;

import com.bank.history.exeption.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тесты для класса GlobalExceptionHandler.
 *
 * @author [Ольга]
 */
class GlobalExceptionHandlerTest {

    /**
     * Проверяет, что обработчик правильно обрабатывает исключение EntityNotFoundException.
     */
    @Test
    void testHandleEntityNotFoundException() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        String errorMessage = "Сущность не найдена";
        EntityNotFoundException ex = new EntityNotFoundException(errorMessage);

        ResponseEntity<String> response = handler.handleEntityNotFoundException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }

    /**
     * Вспомогательный метод для создания MethodParameter в тесте
     */
    public void dummyMethod(String parameter) {
        // фиктивный метод
    }

    /**
     * Проверяет, что обработчик правильно обрабатывает исключение MethodArgumentNotValidException.
     */
    @Test
    void testHandleMethodArgumentNotValidException() throws NoSuchMethodException {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // Получаем Method и создаем MethodParameter для фиктивного метода dummyMethod
        Method method = this.getClass().getMethod("dummyMethod", String.class);
        MethodParameter methodParameter = new MethodParameter(method, 0);

        // Создаем BindingResult с ошибками
        BindingResult bindingResult = new BeanPropertyBindingResult(new Object(), "target");
        bindingResult.addError(new ObjectError("target", "error message"));

        // Инициализируем MethodArgumentNotValidException
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(methodParameter, bindingResult);

        // Тестируем обработчик исключений
        ResponseEntity<String> response = handler.handleMethodArgumentNotValidException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid request parameters", response.getBody());
    }

    /**
     * Проверяет, что обработчик правильно обрабатывает исключение MethodArgumentTypeMismatchException.
     */
    @Test
    void testHandleMethodArgumentTypeMismatchException() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException(null, null, null, null, null);

        ResponseEntity<String> response = handler.handleMethodArgumentTypeMismatchException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid request parameter type", response.getBody());
    }

    /**
     * Проверяет, что обработчик правильно обрабатывает любое другое исключение.
     */
    @Test
    void testHandleGenericException() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Exception ex = new Exception("Произошла неизвестная ошибка");

        ResponseEntity<String> response = handler.handleGenericException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An unexpected error occurred", response.getBody());
    }
}