package com.hotelbooking.touroperatorservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HikariCPConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        // Укажите URL базы данных
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_booking");

        // Укажите имя пользователя и пароль для подключения к базе данных
        hikariConfig.setUsername("yourUsername");
        hikariConfig.setPassword("yourPassword");

        // Конфигурация пула соединений HikariCP
        hikariConfig.setMaximumPoolSize(10); // Максимальное количество соединений в пуле
        hikariConfig.setMinimumIdle(5);      // Минимальное количество неиспользуемых соединений
        hikariConfig.setIdleTimeout(30000);  // Время ожидания неактивного соединения (в миллисекундах)
        hikariConfig.setMaxLifetime(600000); // Максимальное время жизни соединения (в миллисекундах)
        hikariConfig.setConnectionTimeout(30000); // Максимальное время ожидания соединения (в миллисекундах)

        // Создаём и возвращаем DataSource на основе настроек HikariConfig
        return new HikariDataSource(hikariConfig);
    }
}
