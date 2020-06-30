package com.vijitha.feedback.collector.service.mapper;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.mapper.decorators.FeedbackTransformerDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * Mapper using MapStruct
 * Ref.: http://mapstruct.org/documentation/dev/reference/html/
 */
@Mapper(componentModel = "spring")
@DecoratedWith(FeedbackTransformerDecorator.class)
public interface FeedbackTransformer {

    Feedback toFeedback(FeedbackDto feedbackDto);

    FeedbackDto toFeedbackDto(Feedback feedback);
}

