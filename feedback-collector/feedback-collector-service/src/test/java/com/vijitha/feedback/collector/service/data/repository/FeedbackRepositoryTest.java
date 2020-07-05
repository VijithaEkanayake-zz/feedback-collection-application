package com.vijitha.feedback.collector.service.data.repository;

import com.vijitha.feedback.collector.service.data.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@DataMongoTest
@Import({EmbeddedMongoAutoConfiguration.class})
@TestPropertySource(properties = {"spring.data.mongodb.database=feedback"})
public class FeedbackRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    public void givenFeedback_whenFindByVId_thenFindFeedback() {
        UUID feedbackId = UUID.randomUUID();
        Feedback feedback = Feedback.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        feedbackRepository.save(feedback).block();
        Mono<Feedback> feedbackMono = feedbackRepository.findById(feedbackId);

        StepVerifier
                .create(feedbackMono)
                .assertNext(feedback1 -> {
                    assertEquals("Vijitha Ekanayake", feedback1.getName());
                    assertEquals(feedbackId , feedback1.getId());
                    assertEquals(feedback1.getComment(), feedback.getComment());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void givenFeedback_thenFindAll() {
        UUID feedbackId = UUID.randomUUID();
        Feedback feedback = Feedback.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        feedbackRepository.save(feedback).block();
        Flux<Feedback> feedbackFlux = feedbackRepository.findAll();

        StepVerifier
                .create(feedbackFlux)
                .assertNext(feedback1 -> {
                    assertEquals("Vijitha Ekanayake", feedback1.getName());
                    assertEquals(feedbackId , feedback1.getId());
                    assertEquals(feedback1.getComment(), feedback.getComment());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void givenFeedback_whenSave_thenSaveFeedback() {
        UUID feedbackId = UUID.randomUUID();
        Feedback feedback = Feedback.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        Mono<Feedback> feedbackMono = feedbackRepository.save(feedback);

        StepVerifier
                .create(feedbackMono)
                .assertNext(feedback1 -> assertNotNull(feedback1.getId()))
                .expectComplete()
                .verify();
    }

}