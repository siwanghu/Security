package com.auditoryworks.status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private boolean flag;
    private String message;
    private long timestamp;
}
