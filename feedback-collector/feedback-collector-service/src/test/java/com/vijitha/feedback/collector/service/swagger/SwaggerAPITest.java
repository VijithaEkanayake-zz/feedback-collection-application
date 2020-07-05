package com.vijitha.feedback.collector.service.swagger;

import com.vijitha.feedback.collector.domain.dto.FeedbackDto;
import com.vijitha.feedback.collector.service.data.model.Feedback;
import com.vijitha.feedback.collector.service.data.repository.FeedbackRepository;
import com.vijitha.feedback.collector.service.mapper.FeedbackTransformer;
import com.vijitha.feedback.collector.service.service.FeedbackService;
import com.vijitha.feedback.collector.service.service.impl.FeedbackServiceImpl;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

@SpringBootTest
public class SwaggerAPITest extends AbstractTestNGSpringContextTests {

    @Test
    public void contextLoads() {
    }

}