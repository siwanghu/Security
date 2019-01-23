package com.auditoryworks.service;

import com.auditoryworks.domain.MDMessage;
import com.auditoryworks.repository.MDMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MDServiceImpl implements MDService {

    @Autowired
    MDMessageRepository mdMessageRepository;

    @Override
    public void saveAsrMessage(MDMessage mdMessage) {
        mdMessageRepository.save(mdMessage);
    }

    @Override
    public List<MDMessage> getAll() {
        return mdMessageRepository.getAllByUserName(user());
    }

    public String user(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}