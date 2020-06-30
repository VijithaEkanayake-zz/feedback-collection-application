package com.vijitha.feedback.collector.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class FeedbackDto implements Serializable {

    private UUID id;
    private String name;
    private String comment;
    private int rating;
    private Date creationDate;

    @Tolerate
    public FeedbackDto() {

    }
}
