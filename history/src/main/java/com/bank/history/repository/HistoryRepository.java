package com.bank.history.repository;

import com.bank.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сущностью History.
 * Предоставляет стандартные CRUD-методы для взаимодействия с базой данных.
 *
 * @author [Ольга]
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    // CRUD методы доступны по умолчанию
}
