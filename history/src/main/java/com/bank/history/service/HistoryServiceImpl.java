package com.bank.history.service;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import com.bank.history.exeption.EntityNotFoundException;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация сервисного интерфейса для работы с историями банковских операций.
 * Предоставляет методы для получения списка всех историй, получения истории по идентификатору,
 * создания новой истории и удаления истории по идентификатору.
 *
 * @author [Ольга]
 */
@Service
public class HistoryServiceImpl implements HistoryService{

    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository, HistoryMapper historyMapper) {
        this.historyRepository = historyRepository;
        this.historyMapper = historyMapper;
    }

    /**
     * Получает список всех историй банковских операций.
     *
     * @return Список HistoryDTO
     */
    @Override
    public List<HistoryDTO> getAllHistories() {
        return historyRepository.findAll().stream()
                .map(historyMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Получает историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     * @return HistoryDTO
     * @throws EntityNotFoundException если история не найдена
     */
    @Override
    public HistoryDTO getHistoryById(Long id) {
        History history = historyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("History not found"));
        return historyMapper.toDTO(history);
    }

    /**
     * Создает новую историю банковской операции.
     *
     * @param historyDTO DTO с данными новой истории
     * @return Сохраненная HistoryDTO
     */
    @Override
    public HistoryDTO createHistory(HistoryDTO historyDTO) {
        History history = historyMapper.toEntity(historyDTO);
        History savedHistory = historyRepository.save(history);
        return historyMapper.toDTO(savedHistory);
    }

    /**
     * Обновляет историю банковской операции.
     *
     * @param historyDTO DTO с данными новой истории
     * @return Сохраненная HistoryDTO
     */
    @Override
    public HistoryDTO updateHistory(Long id, HistoryDTO historyDTO) {
        // Реализация логики обновления истории
        History existingHistory = historyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("History not found with id: " + id));

        existingHistory.setTransferAuditId(historyDTO.getTransferAuditId());
        existingHistory.setProfileAuditId(historyDTO.getProfileAuditId());
        existingHistory.setAccountAuditId(historyDTO.getAccountAuditId());
        existingHistory.setAntiFraudAuditId(historyDTO.getAntiFraudAuditId());
        existingHistory.setPublicBankInfoAuditId(historyDTO.getPublicBankInfoAuditId());
        existingHistory.setAuthorizationAuditId(historyDTO.getAuthorizationAuditId());

        History updatedHistory = historyRepository.save(existingHistory);
        return historyMapper.toDTO(updatedHistory);
    }

    /**
     * Удаляет историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     * @throws EntityNotFoundException если история не найдена
     */
    @Override
    public void deleteHistory(Long id) {
        if (!historyRepository.existsById(id)) {
            throw new EntityNotFoundException("History not found");
        }
        historyRepository.deleteById(id);
    }
}

