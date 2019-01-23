package com.auditoryworks.service;

import com.auditoryworks.domain.MDMessage;

import java.util.List;

public interface MDService {
    void saveAsrMessage(MDMessage mdMessage);
    List<MDMessage> getAll();
}
