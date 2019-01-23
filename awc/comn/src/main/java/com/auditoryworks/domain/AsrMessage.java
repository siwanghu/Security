package com.auditoryworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsrMessage {
    private String deviceId;
    private String sessionId;
    private String angle;
    private Long timestamp;
    private String userName;
    private String content;
}