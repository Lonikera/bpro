package com.bank.history.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 Класс конфигурации базы данных для приложения.
 Отвечает за настройку JPA-репозиториев.
 @author [Ольга]
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.bank.history.repository")
public class DatabaseConfig {
    // Дополнительные настройки базы данных при необходимости
}