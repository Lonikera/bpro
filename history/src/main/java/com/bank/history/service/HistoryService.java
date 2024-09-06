package com.bank.history.service;

import com.bank.history.dto.HistoryDTO;

import java.util.List;

/**
 * Сервисный интерфейс для работы с историями банковских операций.
 * Предоставляет методы для получения списка всех историй, получения истории по идентификатору,
 * создания новой истории и удаления истории по идентификатору.
 *
 * @author [Ольга]
 */
public interface HistoryService {
    /**
     * Получает список всех историй банковских операций.
     *
     * @return Список HistoryDTO
     */
    List<HistoryDTO> getAllHistories();

    /**
     * Получает историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     * @return HistoryDTO
     */
    HistoryDTO getHistoryById(Long id);

    /**
     * Обновляет историю банковской операции.
     *
     * @param historyDTO DTO с данными обновленной истории
     * @return Сохраненная HistoryDTO
     */
    HistoryDTO updateHistory(Long id, HistoryDTO historyDTO);

    /**
     * Создает новую историю банковской операции.
     *
     * @param historyDTO DTO с данными новой истории
     * @return Сохраненная HistoryDTO
     */
    HistoryDTO createHistory(HistoryDTO historyDTO);

    /**
     * Удаляет историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     */
    void deleteHistory(Long id);
}
