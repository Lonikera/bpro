package com.bank.history.repository;

import com.bank.history.entity.History;
import com.bank.history.repository.HistoryRepository;
import com.bank.history.util.NullCheckUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для {@link HistoryRepository}.
 * Проверяет базовые CRUD-операции для сущности {@link History}.
 */
@DataJpaTest
class HistoryRepositoryTest {

    @Autowired
    private HistoryRepository historyRepository;

    /**
     * Тестирует сохранение новой сущности {@link History}.
     * Создает новый объект {@link History}, сохраняет его и проверяет сохраненную сущность.
     */
    @Test
    void testSaveHistory() {
        History history = new History();
        history.setId(1L);
        history.setTransferAuditId(2L);
        history.setProfileAuditId(3L);
        history.setAccountAuditId(4L);
        history.setAntiFraudAuditId(5L);
        history.setPublicBankInfoAuditId(6L);
        history.setAuthorizationAuditId(7L);

        History savedHistory = NullCheckUtils.checkNotNull(historyRepository.save(history), "Ошибка при сохранении истории.");

        assertNotNull(savedHistory.getId());
        assertEquals(history.getId(), savedHistory.getId());
        assertEquals(history.getTransferAuditId(), savedHistory.getTransferAuditId());
        assertEquals(history.getProfileAuditId(), savedHistory.getProfileAuditId());
        assertEquals(history.getAccountAuditId(), savedHistory.getAccountAuditId());
        assertEquals(history.getAntiFraudAuditId(), savedHistory.getAntiFraudAuditId());
        assertEquals(history.getPublicBankInfoAuditId(), savedHistory.getPublicBankInfoAuditId());
        assertEquals(history.getAuthorizationAuditId(), savedHistory.getAuthorizationAuditId());
    }

    /**
     * Тестирует получение сущности {@link History} по ее ID.
     * Сохраняет новую сущность {@link History}, затем получает ее по ID и проверяет полученную сущность.
     */
    @Test
    void testFindById() {
        History history = new History();
        history.setId(1L);
        history.setTransferAuditId(2L);
        history.setProfileAuditId(3L);
        history.setAccountAuditId(4L);
        history.setAntiFraudAuditId(5L);
        history.setPublicBankInfoAuditId(6L);
        history.setAuthorizationAuditId(7L);

        History savedHistory = NullCheckUtils.checkNotNull(historyRepository.save(history), "Ошибка при сохранении истории.");

        Optional<History> foundHistory = historyRepository.findById(savedHistory.getId());

        assertTrue(foundHistory.isPresent());
        assertEquals(savedHistory.getId(), foundHistory.get().getId());
        assertEquals(savedHistory.getTransferAuditId(), foundHistory.get().getTransferAuditId());
        assertEquals(savedHistory.getProfileAuditId(), foundHistory.get().getProfileAuditId());
        assertEquals(savedHistory.getAccountAuditId(), foundHistory.get().getAccountAuditId());
        assertEquals(savedHistory.getAntiFraudAuditId(), foundHistory.get().getAntiFraudAuditId());
        assertEquals(savedHistory.getPublicBankInfoAuditId(), foundHistory.get().getPublicBankInfoAuditId());
        assertEquals(savedHistory.getAuthorizationAuditId(), foundHistory.get().getAuthorizationAuditId());
    }

    /**
     * Тестирует получение всех сущностей {@link History}.
     * Сохраняет две сущности {@link History}, затем получает все сущности и проверяет, что список содержит сохраненные сущности.
     */
    @Test
    void testFindAll() {
        History history1 = new History();
        history1.setId(1L);
        history1.setTransferAuditId(2L);
        history1.setProfileAuditId(3L);
        history1.setAccountAuditId(4L);
        history1.setAntiFraudAuditId(5L);
        history1.setPublicBankInfoAuditId(6L);
        history1.setAuthorizationAuditId(7L);

        History history2 = new History();
        history2.setId(2L);
        history2.setTransferAuditId(8L);
        history2.setProfileAuditId(9L);
        history2.setAccountAuditId(10L);
        history2.setAntiFraudAuditId(11L);
        history2.setPublicBankInfoAuditId(12L);
        history2.setAuthorizationAuditId(13L);

        NullCheckUtils.checkNotNull(historyRepository.save(history1), "Ошибка при сохранении истории 1.");
        NullCheckUtils.checkNotNull(historyRepository.save(history2), "Ошибка при сохранении истории 2.");

        List<History> allHistories = historyRepository.findAll();

        assertEquals(2, allHistories.size());
        assertTrue(allHistories.contains(history1));
        assertTrue(allHistories.contains(history2));
    }
}