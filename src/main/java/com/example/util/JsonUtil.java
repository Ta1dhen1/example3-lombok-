package com.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String serialize(List<T> objects) {
        try {
            logger.info("Сериализация объектов в JSON.");
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            logger.error("Ошибка сериализации: ", e);
            return null;
        }
    }

    public static <T> List<T> deserializeList(String json, Class<T> clazz) {
        try {
            logger.info("Десериализация JSON в объекты.");
            return objectMapper.readValue(json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            logger.error("Ошибка десериализации: ", e);
            return null;
        }
    }
}
