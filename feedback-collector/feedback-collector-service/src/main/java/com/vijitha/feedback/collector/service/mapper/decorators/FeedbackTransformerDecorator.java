package com.vijitha.feedback.collector.service.mapper.decorators;

import com.vijitha.feedback.collector.service.mapper.FeedbackTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * MapStruct :: Decorator
 * Ref.: http://mapstruct.org/documentation/dev/reference/html/#customizing-mappers-using-decorators
 */
public abstract class FeedbackTransformerDecorator implements FeedbackTransformer {

    @Autowired
    @Qualifier("delegate")
    FeedbackTransformer enquiryTransformer;

   }
