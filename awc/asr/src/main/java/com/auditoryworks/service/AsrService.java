package com.auditoryworks.service;

import com.auditoryworks.domain.Asr;
import com.auditoryworks.status.Message;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AsrService {
    Message saveAsr(Asr asr);
    Message deleteAsrById(String id);
    Page<Asr> findPage(int pageNum,int pageSize);
    List<Asr> findAll();
    String user();
}