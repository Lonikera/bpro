package com.bank.history.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для {@link NullCheckUtils}.
 *
 * @author [Ольга]
 */
class NullCheckUtilsTest {

    /**
     * Тест проверяет, что метод {@link NullCheckUtils#checkNotNull(Object, String)} возвращает
     * переданный объект, если он не null.
     */
    @Test
    void testCheckNotNullWithNonNullObject() {
        String nonNullObject = "Не null объект";
        String result = NullCheckUtils.checkNotNull(nonNullObject, "Объект не должен быть null");
        Assertions.assertSame(nonNullObject, result);
    }

    /**
     * Тест проверяет, что метод {@link NullCheckUtils#checkNotNull(Object, String)} выбрасывает
     * {@link IllegalArgumentException} с корректным сообщением об ошибке, если передан null объект.
     */
    @Test
    void testCheckNotNullWithNullObject() {
        String nullObject = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> NullCheckUtils.checkNotNull(nullObject, "Объект не должен быть null"),
                "Ожидается IllegalArgumentException с сообщением об ошибке");
    }
}
