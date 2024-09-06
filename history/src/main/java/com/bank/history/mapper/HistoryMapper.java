package com.bank.history.mapper;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Маппер для преобразования между сущностью History и DTO HistoryDTO.
 * Отвечает за конвертацию данных между объектами разных слоев приложения.
 *
 * @author [Ольга]
 */
@Mapper(componentModel = "spring")
public interface HistoryMapper {

    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    HistoryDTO toDTO(History history);

    History toEntity(HistoryDTO historyDTO);
}
