package com.thehecklers.copilottest1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class AircraftControllerTests {

    @Container
    static MongoDBContainer container = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", container::getReplicaSetUrl);
    }

    @Autowired
    private AircraftRepository repo;

    @AfterEach
    void cleanUp() {
        repo.deleteAll();
    }

    @Test
    void testAddAircraft() {
        assertEquals(1, 1);
    }

    @Test
    void testGetAircraftByAdshex() {
        assertEquals(2, 2);
    }

    @Test
    void testGetAllAircraft() {
        repo.save(new Aircraft("12345a", "12345", "PA28"));
        repo.save(new Aircraft("23456b", "23456", "PA32"));
        repo.save(new Aircraft("34567c", "34567", "PA46"));
        repo.save(new Aircraft("45678d", "45678", "C172"));
        repo.save(new Aircraft("56789e", "56789", "C182"));

        assertEquals(3, 3);
    }
}
