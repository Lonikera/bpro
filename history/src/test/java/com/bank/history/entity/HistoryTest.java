package com.bank.history.entity;

import com.bank.history.entity.History;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс для тестирования сущности History.
 * Проверяет работу геттеров и сеттеров сущности.
 *
 * @author [Ольга]
 */
class HistoryTest {

    /**
     * Тестовый метод для проверки работы геттеров и сеттеров сущности History.
     * Создает объект History, устанавливает значения полей, а затем проверяет, что
     * значения, полученные с помощью геттеров, соответствуют установленным.
     */
    @Test
     void testGettersAndSetters() {
        History history = new History();
        history.setId(1L);
        history.setTransferAuditId(2L);
        history.setProfileAuditId(3L);
        history.setAccountAuditId(4L);
        history.setAntiFraudAuditId(5L);
        history.setPublicBankInfoAuditId(6L);
        history.setAuthorizationAuditId(7L);

        assertEquals(1L, history.getId());
        assertEquals(2L, history.getTransferAuditId());
        assertEquals(3L, history.getProfileAuditId());
        assertEquals(4L, history.getAccountAuditId());
        assertEquals(5L, history.getAntiFraudAuditId());
        assertEquals(6L, history.getPublicBankInfoAuditId());
        assertEquals(7L, history.getAuthorizationAuditId());
    }
 }