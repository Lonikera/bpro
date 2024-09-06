package com.bank.history.service;

import com.bank.history.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс для проверки работы HistoryService.
 * Содержит пример теста для проверки корректности работы сервиса.
 *
 * @author [Ольга]
 */
@SpringBootTest
class HistoryServiceTest {

    @Autowired
    private HistoryService historyService;

    /**
     * Тестовый метод для проверки примера.
     * Проверяет, что 1 равно 1.
     */
    @Test
    public void testExample() {
        // Пример теста
        assertEquals(1, 1);
    }
}