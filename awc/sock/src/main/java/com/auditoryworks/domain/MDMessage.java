package com.auditoryworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "asr_message")
public class MDMessage {
    private String deviceId;
    private String sessionId;
    private String angle;
    private Long timestamp;
    private String userName;
    private String content;
}
