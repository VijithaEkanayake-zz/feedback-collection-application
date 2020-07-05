package com.vijitha.feedback.collector.service.controller;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.service.FeedbackService;
import com.vijitha.feedback.collector.service.service.MinioPublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
public class FeedbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private MinioPublisherService minioPublisherService;

    @PostMapping("/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FeedbackResponse> createFeedback(@RequestBody final FeedbackDto dto) {
        if (dto.getId() == null) {
            dto.setId(UUID.randomUUID());
        }
        if (dto.getCreationDate() == null) {
            dto.setCreationDate(new Date());
        }
        LOGGER.info("Request received to create a feedback for the user [{}] and feedback id [{}]", dto.getName(), dto.getId());
        Mono<Feedback> feedback = feedbackService.addFeedback(dto);
        return createFeedbackResponse(feedback);
    }

    @GetMapping("/feedback")
    @ResponseStatus(HttpStatus.OK)
    public Flux<FeedbackDto> getAllFeedbacks() {
        LOGGER.info("Request received to get all feedback.");
        return feedbackService.getAllFeedbacks();
    }

    private Mono<FeedbackResponse> createFeedbackResponse(Mono<Feedback> feedback) {
         return feedback.map(feedback1 -> FeedbackResponse.builder().entityId(feedback1.getId()).build());
    }

}
