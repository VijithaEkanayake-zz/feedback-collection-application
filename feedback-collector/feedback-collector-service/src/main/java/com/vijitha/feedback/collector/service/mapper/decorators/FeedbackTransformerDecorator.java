package com.vijitha.feedback.collector.service.mapper.decorators;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.mapper.FeedbackTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * MapStruct :: Decorator
 * Ref.: http://mapstruct.org/documentation/dev/reference/html/#customizing-mappers-using-decorators
 */
public abstract class FeedbackTransformerDecorator implements FeedbackTransformer {

    @Autowired
    @Qualifier("delegate")
    FeedbackTransformer feedbackTransformer;

    @Value("${spring.minio.log.ref.path:http://minio:9000/feedback/logs}")
    private String logReference;

    public Feedback toFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackTransformer.toFeedback(feedbackDto);
        feedback.setLogReference(logReference);
        return feedback;
    }
   }
