package com.bank.history.handler;

import com.bank.history.exeption.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Глобальный обработчик исключений для контроллеров.
 * Отвечает за обработку различных типов исключений и возврат соответствующих HTTP-ответов.
 *
 * @author [Ольга]
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Обрабатывает исключение EntityNotFoundException и возвращает HTTP-ответ с кодом 404 Not Found.
     *
     * @param ex Исключение EntityNotFoundException
     * @return ResponseEntity с сообщением об ошибке
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.error("EntityNotFoundException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение MethodArgumentNotValidException и возвращает HTTP-ответ с кодом 400 Bad Request.
     *
     * @param ex Исключение MethodArgumentNotValidException
     * @return ResponseEntity с сообщением об ошибке
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("MethodArgumentNotValidException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("Invalid request parameters", HttpStatus.BAD_REQUEST);
    }

    /**
     * Обрабатывает исключение MethodArgumentTypeMismatchException и возвращает HTTP-ответ с кодом 400 Bad Request.
     *
     * @param ex Исключение MethodArgumentTypeMismatchException
     * @return ResponseEntity с сообщением об ошибке
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        logger.error("MethodArgumentTypeMismatchException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("Invalid request parameter type", HttpStatus.BAD_REQUEST);
    }

    /**
     * Обрабатывает любое другое исключение и возвращает HTTP-ответ с кодом 500 Internal Server Error.
     *
     * @param ex Исключение
     * @return ResponseEntity с сообщением об ошибке
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Exception: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
