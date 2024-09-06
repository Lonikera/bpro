package com.bank.history.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс для настройки OpenAPI 3.0.
 * Отвечает за создание и настройку объекта OpenAPI.
 *
 * @author [Ольга]
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Создает и настраивает объект OpenAPI.
     * Устанавливает заголовок, версию и описание API.
     * @return Настроенный объект OpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("History Service API")
                        .version("1.0.0")
                        .description("API для управления историей банковских операций"));
    }
}
