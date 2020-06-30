package com.vijitha.feedback.collector.service.data.repository;

import com.vijitha.feedback.collector.service.data.model.Feedback;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface FeedbackRepository extends ReactiveMongoRepository<Feedback, UUID> {

}
