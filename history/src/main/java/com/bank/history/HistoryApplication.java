package com.bank.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bank.history.config.DatabaseConfig;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Основной класс приложения для работы с историями банковских операций.
 * Отвечает за запуск Spring Boot приложения.
 *
 */
@SpringBootApplication
@EnableEurekaClient
@Import(DatabaseConfig.class)
public class HistoryApplication {
    public static void main(String[] args) {

        SpringApplication.run(HistoryApplication.class, args);

    }
}
