package com.bank.history.mapper;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс HistoryMapperTest представляет собой набор тестов для проверки работы HistoryMapper.
 * Он проверяет корректность преобразования сущности History в DTO и обратно.
 *
 * @author [Ольга]
 */
class HistoryMapperTest {

    private final HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);

    /**
     * Тестирует преобразование сущности History в DTO.
     */
    @Test
    void testEntityToDto() {
        History history = new History();
        history.setId(1L);

        HistoryDTO historyDTO = historyMapper.toDTO(history);
        assertEquals(1L, historyDTO.getId());
    }

    /**
     * Тестирует преобразование DTO в сущность History.
     */
    @Test
    void testDtoToEntity() {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(1L);

        History history = historyMapper.toEntity(historyDTO);
        assertEquals(1L, history.getId());
    }
}