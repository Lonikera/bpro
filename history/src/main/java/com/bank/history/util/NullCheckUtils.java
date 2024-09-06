package com.bank.history.util;

import org.springframework.util.Assert;

/**
 * Вспомогательный класс для проверки объектов на null.
 *
 * @author [Ольга]
 */
public class NullCheckUtils {

    private NullCheckUtils() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    }

    /**
     * Проверяет, что объект не является null, и выбрасывает исключение, если он null.
     *
     * @param object     Объект для проверки
     * @param errorMsg   Сообщение об ошибке, если объект null
     * @param <T>        Тип объекта
     * @return           Объект, если он не null
     * @throws IllegalArgumentException Если объект null
     */
    public static <T> T checkNotNull(T object, String errorMsg) {
        Assert.notNull(object, errorMsg);
        return object;
    }
}
