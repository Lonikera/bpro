package com.bank.history.controller;

import com.bank.history.dto.HistoryDTO;
import com.bank.history.entity.controller.HistoryController;
import com.bank.history.exeption.EntityNotFoundException;
import com.bank.history.service.HistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Этот класс представляет тестовый набор для HistoryController.
 * Он тестирует различные конечные точки HistoryController и обеспечивает правильное поведение контроллера.
 */
@WebMvcTest(HistoryController.class)
class HistoryControllerTest {

    /**
     * Объект MockMvc для выполнения HTTP-запросов.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Заглушка для сервиса HistoryService.
     */
    @MockBean
    private HistoryService historyService;

    /**
     * Объект ObjectMapper для работы с JSON.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Инициализирует Mockito-заглушки перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Тестирует получение списка всех историй.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testGetAllHistories() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(1L);
        when(historyService.getAllHistories()).thenReturn(Arrays.asList(historyDTO));

        mockMvc.perform(get("/api/history"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    /**
     * Тестирует получение истории по идентификатору.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testGetHistoryById() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(1L);
        when(historyService.getHistoryById(1L)).thenReturn(historyDTO);

        mockMvc.perform(get("/api/history/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    /**
     * Тестирует создание новой истории.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testCreateHistory() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(1L);
        when(historyService.createHistory(any(HistoryDTO.class))).thenReturn(historyDTO);

        mockMvc.perform(post("/api/history")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(historyDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)));
    }

    /**
     * Тестирует обновление существующей истории.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testUpdateHistory() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(1L);
        when(historyService.updateHistory(anyLong(), any(HistoryDTO.class))).thenReturn(historyDTO);

        mockMvc.perform(put("/api/history/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(historyDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    /**
     * Тестирует удаление истории.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testDeleteHistory() throws Exception {
        doNothing().when(historyService).deleteHistory(anyLong());

        mockMvc.perform(delete("/api/history/1"))
                .andExpect(status().isNoContent());

        verify(historyService, times(1)).deleteHistory(1L);
    }

    /**
     * Тестирует получение истории, когда она не найдена.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testGetHistoryById_NotFound() throws Exception {
        when(historyService.getHistoryById(anyLong())).thenThrow(new EntityNotFoundException("История не найдена"));

        mockMvc.perform(get("/api/history/1"))
                .andExpect(status().isNotFound());
    }

    /**
     * Тестирует удаление истории, когда она не найдена.
     *
     * @throws Exception если возникает ошибка во время выполнения теста
     */
    @Test
    void testDeleteHistory_NotFound() throws Exception {
        doThrow(new EntityNotFoundException("История не найдена")).when(historyService).deleteHistory(anyLong());

        mockMvc.perform(delete("/api/history/1"))
                .andExpect(status().isNotFound());
    }
}