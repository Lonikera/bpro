package com.bank.history.exeption;

/**
 * Исключение, возникающее при отсутствии сущности в базе данных.
 *
 * @author [Ольга]
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Создает новое исключение с указанным сообщением.
     *
     * @param message Сообщение об ошибке
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
