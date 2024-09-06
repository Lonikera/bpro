package com.bank.history.entity.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.service.HistoryService;
import com.bank.history.util.NullCheckUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * REST-контроллер для работы с историями банковских операций.
 * Отвечает за обработку HTTP-запросов, связанных с получением, созданием и удалением историй.
 *
 * @author [Ольга]
 */
@RestController
@RequestMapping("/api/history")
@Validated
@Tag(name = "History Controller", description = "Управление историями банковских операций")
public class HistoryController {

    private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {

        this.historyService = historyService;
    }

    /**
     * Получает список всех историй банковских операций.
     *
     * @return ResponseEntity с списком HistoryDTO
     */
    @Operation(summary = "Получить все истории")
    @GetMapping
    public ResponseEntity<List<HistoryDTO>> getAllHistories() {
        logger.info("Получение всех историй");
        List<HistoryDTO> histories = historyService.getAllHistories();
        return ResponseEntity.ok(histories);
    }

    /**
     * Получает историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     * @return ResponseEntity с HistoryDTO
     */
    @Operation(summary = "Получить историю по идентификатору")
    @GetMapping("/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable Long id) {
        logger.info("Получение истории по id: {}", id);
        HistoryDTO historyDTO = historyService.getHistoryById(id);
        NullCheckUtils.checkNotNull(historyDTO, "История не найдена");
        return ResponseEntity.ok(historyDTO);
    }

    /**
     * Создает новую историю банковской операции.
     *
     * @param historyDTO DTO с данными новой истории
     * @return ResponseEntity с сохраненной HistoryDTO
     */
    @Operation(summary = "Создать новую историю")
    @PostMapping
    public ResponseEntity<HistoryDTO> createHistory(@Valid @RequestBody HistoryDTO historyDTO) {
        logger.info("Создание новой истории: {}", historyDTO);
        HistoryDTO savedHistory = historyService.createHistory(historyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHistory);
    }

    /**
     * Обновляет существующую историю банковской операции.
     *
     * @param id Идентификатор истории
     * @param historyDTO DTO с данными обновленной истории
     * @return ResponseEntity с обновленной HistoryDTO
     */
    @Operation(summary = "Обновить существующую историю")
    @PutMapping("/{id}")
    public ResponseEntity<HistoryDTO> updateHistory(@PathVariable Long id, @Valid @RequestBody HistoryDTO historyDTO) {
        logger.info("Обновление истории с id: {}", id);
        HistoryDTO updatedHistory = historyService.updateHistory(id, historyDTO);
        return ResponseEntity.ok(updatedHistory);
    }
    /**
     * Удаляет историю банковской операции по идентификатору.
     *
     * @param id Идентификатор истории
     * @return ResponseEntity с пустым телом
     */
    @Operation(summary = "Удалить историю по идентификатору")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id) {
        logger.info("Удаление истории по id: {}", id);
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}
