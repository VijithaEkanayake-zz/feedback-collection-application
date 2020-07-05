package com.vijitha.feedback.collector.service.service.impl;

import com.vijitha.feedback.collector.service.service.MinioPublisherService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MinioPublisherServiceImpl implements MinioPublisherService {

    private static final Logger LOGGER = LogManager.getLogger(MinioPublisherServiceImpl.class);

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
            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioBucketName).build());
            if (!isExist) {
                // Make a new bucket called to hold a zip file of photos.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioBucketName).build());
            }

            // Upload the log file to the bucket with putObject
            minioClient.uploadObject(UploadObjectArgs.builder()
                    .bucket(minioBucketName)
                    .object(minioObjectName)
                    .filename(logLocation)
                    .build());
        } catch (Exception e) {
            LOGGER.error("Error occurred publish the log to MinIO bucket {[]} ", minioBucketName, e);
        }
    }
}




