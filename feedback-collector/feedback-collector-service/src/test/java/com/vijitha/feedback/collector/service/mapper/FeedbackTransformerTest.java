package com.vijitha.feedback.collector.service.mapper;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.UUID;

@Import(FeedbackTransformerImpl.class)
@ComponentScan("com.vijitha.feedback.collector.service.mapper")
@DirtiesContext
public class FeedbackTransformerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FeedbackTransformer feedbackTransformer;

    @Test
    public void fromFeedbackToFeedbackDto() {
        //Given
        UUID feedbackId = UUID.randomUUID();
        Feedback feedback = Feedback.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();

        //When
        final FeedbackDto feedbackDto = feedbackTransformer.toFeedbackDto(feedback);

        //Then
        Assert.assertNotNull(feedbackDto);
        Assert.assertEquals(feedbackDto.getId(), feedbackId);
    }


    @Test
    public void fromFeedbackDtoToFeedback() {
        //Given
        UUID feedbackId = UUID.randomUUID();
        FeedbackDto feedbackDto = FeedbackDto.builder().id(feedbackId)
                .name("Vijitha Ekanayake").comment("Awesome").rating(5).creationDate(new Date()).build();

        //When
        final Feedback feedback = feedbackTransformer.toFeedback(feedbackDto);

        //Then
        Assert.assertNotNull(feedback);
        Assert.assertEquals(feedback.getId(), feedbackId);
    }

}