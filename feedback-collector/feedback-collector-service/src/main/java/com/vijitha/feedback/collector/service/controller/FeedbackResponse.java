package com.vijitha.feedback.collector.service.controller;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FeedbackResponse implements Serializable {

    private LocalDateTime createdDate;
    private UUID entityId;

    private static LocalDateTime $default$createdDate() {
        return LocalDateTime.now();
    }

    FeedbackResponse(LocalDateTime createdDate, UUID entityId) {
        this.createdDate = createdDate;
        this.entityId = entityId;
    }

    public static FeedbackResponse.FeedbackResponseBuilder builder() {
        return new FeedbackResponse.FeedbackResponseBuilder();
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public UUID getEntityId() {
        return this.entityId;
    }

    public static class FeedbackResponseBuilder {
        private boolean createdDate$set;
        private LocalDateTime createdDate;
        private UUID eventId;
        private UUID entityId;

        FeedbackResponseBuilder() {
        }

        public FeedbackResponse.FeedbackResponseBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            this.createdDate$set = true;
            return this;
        }

        public FeedbackResponse.FeedbackResponseBuilder eventId(UUID eventId) {
            this.eventId = eventId;
            return this;
        }

        public FeedbackResponse.FeedbackResponseBuilder entityId(UUID entityId) {
            this.entityId = entityId;
            return this;
        }

        public FeedbackResponse build() {
            LocalDateTime createdDate = this.createdDate;
            if (!this.createdDate$set) {
                createdDate = FeedbackResponse.$default$createdDate();
            }

            return new FeedbackResponse(createdDate, this.entityId);
        }

        public String toString() {
            return "FeedbackResponse.FeedbackResponseBuilder(createdDate=" + this.createdDate + ", entityId=" + this.entityId + ")";
        }
    }

}
