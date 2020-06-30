package com.vijitha.feedback.collector.service.data.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Document
public class Feedback implements Serializable {

    @Id
    private UUID id;
    private String name;
    private String comment;
    private int rating;
    private Date creationDate;

    @Tolerate
    public Feedback() {

    }
}
