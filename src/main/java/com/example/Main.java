package com.example;

import com.example.service.PersonService;
import com.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting the Advanced Project application.");

        // Create some people
        PersonService personService = new PersonService();
        List<Person> people = personService.createPeople();

        // Serialize to JSON
        String json = personService.serializeToJson(people);
        logger.info("Serialized JSON: {}", json);

        // Deserialize from JSON
        List<Person> deserializedPeople = personService.deserializeFromJson(json);
        logger.info("Deserialized People: {}", deserializedPeople);

        logger.info("Application finished successfully.");
    }
}
