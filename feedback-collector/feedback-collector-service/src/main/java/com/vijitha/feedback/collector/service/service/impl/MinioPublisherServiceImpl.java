package com.vijitha.feedback.collector.service.service.impl;

import com.vijitha.feedback.collector.service.service.MinioPublisherService;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MinioPublisherServiceImpl implements MinioPublisherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinioPublisherServiceImpl.class);

    @Autowired
    private MinioClient minioClient;

    @Value("${spring.minio.bucket:feedback}")
    private String minioBucketName;

    @Value("${spring.application.info.log.location:/usr/app/logs/info.log}")
    private String logLocation;

    @Value("${spring.minio.info.log.object.name:info.log}")
    private String minioObjectName;

    @Override
    public void publishLogs() {
        LOGGER.info("Publishing application logs to the MinIO bucket [{}]", minioBucketName);
        try {
            minioClient.putObject(minioBucketName, minioObjectName, logLocation);
        } catch(Exception e) {
            LOGGER.error("Error occurred publish the log to MinIO bucket {[]} ", minioBucketName, e);
        }
    }
}




