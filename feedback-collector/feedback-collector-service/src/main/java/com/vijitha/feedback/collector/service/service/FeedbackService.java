package com.vijitha.feedback.collector.service.service;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackService {

    Mono<Feedback> addFeedback(FeedbackDto feedbackDto);

    Flux<FeedbackDto> getAllFeedbacks();

}
