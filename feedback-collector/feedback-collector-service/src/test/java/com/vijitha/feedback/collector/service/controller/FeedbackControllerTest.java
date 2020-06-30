package com.vijitha.feedback.collector.service.controller;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.service.MinioPublisherService;
import com.vijitha.feedback.collector.service.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebFluxTest(controllers = FeedbackController.class)
@Import({FeedbackServiceImpl.class})
public class FeedbackControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FeedbackController controller;

    @MockBean
    @Autowired
    private FeedbackServiceImpl service;

    @MockBean
    @Autowired
    private MinioPublisherService minioPublisherService;

    @Test
    public void addFeedbackTest() {
        // Given
        FeedbackDto feedbackDto = FeedbackDto.builder().id(UUID.randomUUID())
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        Feedback feedback = Feedback.builder().id(UUID.randomUUID())
                                    .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        // When
        when(service.addFeedback(feedbackDto)).thenReturn(Mono.just(feedback));

        FeedbackResponse feedbackResponse = controller.createFeedback(feedbackDto).block();

        // Then
        assertNotNull(feedbackResponse);
        assertEquals(feedbackResponse.getEntityId(), feedback.getId());
        assertNotNull(feedbackResponse.getCreatedDate());
    }

    @Test
    public void getAllFeddbacks() {
        // Given
        FeedbackDto feedbackDto1 = FeedbackDto.builder().id(UUID.randomUUID())
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();
        FeedbackDto feedbackDto2 = FeedbackDto.builder().id(UUID.randomUUID())
                .name("Harsha Ekanayake").comment("Nice").rating(4).creationDate(new Date()).build();
        // When
        when(service.getAllFeedbacks()).thenReturn(Flux.just(feedbackDto1, feedbackDto2));

        Flux<FeedbackDto> feedbackDtoFlux = controller.getAllFeedbacks();

        feedbackDtoFlux.subscribe(feedbackDto -> {
            // Then
            assertNotNull(feedbackDto);
            assertNotNull(feedbackDto.getId());
            assertNotNull(feedbackDto.getComment());
            assertNotNull(feedbackDto.getRating());
        });
    }

}