package com.vijitha.feedback.collector.service.service.impl;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.data.repository.FeedbackRepository;
import com.vijitha.feedback.collector.service.mapper.FeedbackTransformer;
import com.vijitha.feedback.collector.service.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackTransformer feedbackTransformer;

    @Override
    public Mono<Feedback> addFeedback(FeedbackDto feedbackDto) {
        LOGGER.info("Adding Feedback to the feedback repository with feedback id [{}]", feedbackDto.getId());
        LOGGER.debug("Debug Feedback to the feedback repository with feedback id [{}]", feedbackDto.getId());
        LOGGER.trace("TRACE Feedback to the feedback repository with feedback id [{}]", feedbackDto.getId());
        Feedback feedback = feedbackTransformer.toFeedback(feedbackDto);
        return feedbackRepository.save(feedback);
    }

    @Override
    public Flux<FeedbackDto> getAllFeedbacks() {
        LOGGER.info("Fetching all the feedbacks from the feedback repository");
        LOGGER.debug("Fetching all the feedbacks from the feedback repository");
        Flux<Feedback> feedbackFlux = feedbackRepository.findAll();
        return feedbackFlux.map(feedback -> feedbackTransformer.toFeedbackDto(feedback));
    }
}




