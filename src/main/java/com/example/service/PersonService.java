package com.example.service;

import com.example.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Person> createPeople() {
        logger.info("Creating a list of people.");

        return ImmutableList.of(
                new Person("Alice", 30, "alice@example.com"),
                new Person("Bob", 25, "bob@example.com"),
                new Person("Charlie", 35, "charlie@example.com")
        );
    }

    public String serializeToJson(List<Person> people) {
        try {
            logger.info("Serializing people to JSON.");
            return objectMapper.writeValueAsString(people);
        } catch (JsonProcessingException e) {
            logger.error("Error during serialization: ", e);
            return null;
        }
    }

    public List<Person> deserializeFromJson(String json) {
        try {
            logger.info("Deserializing JSON to people.");
            return objectMapper.readValue(json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        } catch (JsonProcessingException e) {
            logger.error("Error during deserialization: ", e);
            return null;
        }
    }
}
