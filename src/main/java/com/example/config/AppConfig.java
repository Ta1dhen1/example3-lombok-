package com.example.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

public class AppConfig {
    private Configuration config;

    public AppConfig() {
        try {
            Configurations configs = new Configurations();
            config = configs.properties(new File("src/main/resources/application.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки конфигурации", e);
        }
    }

    public Configuration getConfig() {
        return config;
    }
}
