package com.auditoryworks.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(indexName = "asr", type = "result", shards = 2, replicas = 1, refreshInterval = "-1")
public class Asr {
    @Id
    private String id;
    @Field
    private String title;
    @Field
    private Long time;
    @Field
    private Long  important;
    @Field
    private Date update;
    @Field
    private String context;
    @Field
    private String user;
}