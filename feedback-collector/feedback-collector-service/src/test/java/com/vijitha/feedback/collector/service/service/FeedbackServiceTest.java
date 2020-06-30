package com.vijitha.feedback.collector.service.service;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.data.repository.FeedbackRepository;
import com.vijitha.feedback.collector.service.mapper.FeedbackTransformer;
import com.vijitha.feedback.collector.service.service.impl.FeedbackServiceImpl;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Import({FeedbackServiceImpl.class})
@ComponentScan(basePackageClasses = {FeedbackTransformer.class})
@DirtiesContext
public class FeedbackServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FeedbackService service;

    @Autowired
    @MockBean
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackTransformer feedbackTransformer;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddFeedback() {
        // Given
        FeedbackDto feedbackDto = FeedbackDto.builder().id(UUID.randomUUID())
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        Feedback feedback = Feedback.builder().id(UUID.randomUUID())
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        // When
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(Mono.just(feedback));

        Feedback feedback1 = service.addFeedback(feedbackDto).block();

        // Then
        assertNotNull(feedback1);
        assertEquals(feedback1.getId(), feedback.getId());
        assertNotNull(feedback1.getComment());

    }


    @Test
    public void testGetAllFeedbacks() {
        // Given
        UUID feedbackId = UUID.randomUUID();
        Feedback feedback = Feedback.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        // When
        when(feedbackRepository.findAll()).thenReturn(Flux.just(feedback));

        Flux<FeedbackDto> feedbackDtoFlux = service.getAllFeedbacks();

        // Then
        StepVerifier
                .create(feedbackDtoFlux)
                .assertNext(feedback1 -> {
                    assertEquals("Vijitha Ekanayake", feedback1.getName());
                    assertEquals(feedbackId , feedback1.getId());
                    assertEquals(feedback1.getComment(), feedback.getComment());
                })
                .expectComplete()
                .verify();

    }

}